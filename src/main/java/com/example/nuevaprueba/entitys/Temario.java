package com.example.nuevaprueba.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Temario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Temario {
    @Id
    private String id;
    private String Tema;
    private String Apunte;  //-->   Link con apunte de ese tema <--
}
