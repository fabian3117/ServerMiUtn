package com.example.nuevaprueba.entitys;

import com.example.nuevaprueba.enums.Carreras;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("Perfil")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Perfil {
    @Id
    private String id;
    private String userName,password,profilePic,legajo,userSIU,name,correoInstitucional;
    private Carreras carrea;
    //-->   Diferencia entre CURSADAS y CURSANDO es que la primera tienen adjunto los horarios  <--
    private ArrayList<NMateria> materiasCursadas;   //-->   Materias CURSADAS en pasado <--
    private ArrayList<NMateriasCursando> materiasCursando;  //-->   CURSANDO ACTUALMENTE    <--
}
