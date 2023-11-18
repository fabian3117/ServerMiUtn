package com.example.nuevaprueba.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("MateriaCursando")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MateriaCursando {
    @Id
    private String id;
    private Materia materia;
    private String aula;
    private String dia;
    private String horario;
    private String sede;

    public MateriaCursando(Materia materia, String aula, String dia, String horario, String sede) {
        this.materia = materia;
        this.aula = aula;
        this.dia = dia;
        this.horario = horario;
        this.sede = sede;
    }
}
