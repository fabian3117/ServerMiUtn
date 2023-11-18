package com.example.nuevaprueba.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("Profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profile {
    @Id
    private String id;
    private ArrayList<MateriaCursando> materiaCursandos;
    private ArrayList<Materia> materiasCursadasAprobadas;
    private ArrayList<Materia> materiasCursadasRegularizadas;


}
