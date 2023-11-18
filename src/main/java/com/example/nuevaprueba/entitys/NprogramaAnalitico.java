package com.example.nuevaprueba.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("programaAnalitico")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NprogramaAnalitico {
    private String id;
    private ArrayList<Temario> temas;

    public NprogramaAnalitico(ArrayList<Temario> temas) {
        this.temas = temas;
    }
}
