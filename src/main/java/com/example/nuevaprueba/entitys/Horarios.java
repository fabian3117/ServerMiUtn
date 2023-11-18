package com.example.nuevaprueba.entitys;

import com.example.nuevaprueba.enums.Sedes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Horarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Horarios {
    private String dia,horaInicio,horaFin,aula;
    private Sedes sede;

}
