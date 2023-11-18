package com.example.nuevaprueba.entitys;
//-->   This is a model of materi   <--

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("Materia")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Materia {

    @Id
    private String id;
    private String nombre;
    private int anio;
    private int cuatri;
    private ArrayList<String> carreras; //-->   Carreras asociadas  <--
    //-->   Requisitos para cursada <--
    private ArrayList<String> materiasCursadas;
    private ArrayList<String> materiasAprobadas;
    //-->   Requisitos para final   <--
    private ArrayList<String> materiasCursadasFinal;
    private ArrayList<String> materiasAprobadasFinal;

    public ArrayList<Temario> getProgramaAnalitico() {
        return programaAnalitico;
    }

    public void setProgramaAnalitico(ArrayList<Temario> programaAnalitico) {
        this.programaAnalitico = programaAnalitico;
    }

    private ArrayList<Temario> programaAnalitico;   //-->   Programa analitico de esta materia  <--


    public Materia(String nombre, int anio, int cuatri, ArrayList<String> carreras) {
        this.nombre = nombre;
        this.anio = anio;
        this.cuatri = cuatri;
        this.carreras = carreras;
    }
}
