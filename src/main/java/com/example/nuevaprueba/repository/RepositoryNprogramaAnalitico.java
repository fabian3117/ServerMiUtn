package com.example.nuevaprueba.repository;

import com.example.nuevaprueba.entitys.NprogramaAnalitico;
import com.example.nuevaprueba.entitys.Temario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface RepositoryNprogramaAnalitico extends MongoRepository<NprogramaAnalitico,String> {
    //ArrayList<Temario> findByIdAndMateriaId()
}
