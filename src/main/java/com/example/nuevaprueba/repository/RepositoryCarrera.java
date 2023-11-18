package com.example.nuevaprueba.repository;

import com.example.nuevaprueba.entitys.Carrera;
import com.example.nuevaprueba.enums.Carreras;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * This is repository of the carreras
 */
@Repository
public interface RepositoryCarrera extends MongoRepository<Carrera, Carreras> {
 ArrayList<Carrera> findById(Carrera id);
 ArrayList<Carrera> findById(String id);

}
