package com.example.nuevaprueba.entitys;

import com.example.nuevaprueba.enums.Cuatrimestres;
import com.example.nuevaprueba.enums.Modalidad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("NMateria")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class NMateria {
    @Id
    private String id;
    private String name,anio;
    private NprogramaAnalitico programaAnalitico;

    private Cuatrimestres cuatrimestre;
    private Modalidad modalidad;
    private ArrayList<String> correlativas;//-->    Para cursar <--


}
