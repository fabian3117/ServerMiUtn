package com.example.nuevaprueba.repository;

import com.example.nuevaprueba.entitys.Materia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMateria extends CrudRepository<Materia,String> {
}
