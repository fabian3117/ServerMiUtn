package com.example.nuevaprueba;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Materias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombreMateria;
    private int anio;
    private int cuatrimestre;
    @Column(columnDefinition = "TEXT")
    private String programa;   //-->   Esta es una referencia al archivo markdown asociado a esa materia   <--

}
