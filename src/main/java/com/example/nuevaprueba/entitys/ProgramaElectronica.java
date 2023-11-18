package com.example.nuevaprueba.entitys;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document("programaIngenieriaElectronica")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProgramaElectronica {
    //-->   Programa de ingenieria Electronica
    @Id
    private String id;
//    private String descripcionIng;
    private ArrayList<Materia> materias; //-->  Tenemos las materias

}
