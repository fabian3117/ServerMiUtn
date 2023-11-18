package com.example.nuevaprueba.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Fechas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FechasExamenes {
    @Id
    private String id;
    private String Fecha;
    private NMateria materia;
}
