package com.example.nuevaprueba.entitys;

import com.example.nuevaprueba.enums.Carreras;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

/**
 * Estas son las carreras que tenemos disponibles - Diferenciadas por su id que contiene el nombre de su carrera
 */
@Document("Carrera")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Carrera {
    @Id
    private Carreras id;    //-->   This is name of carrera example : electronic - industry
    private ArrayList<NMateria> materias;
}
