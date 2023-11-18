package com.example.nuevaprueba.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("NMateriasCursando")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NMateriasCursando {
    private String id;
    private NMateria materia;
    private Horarios horario;
}
