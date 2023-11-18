package com.example.nuevaprueba.repository;

import com.example.nuevaprueba.entitys.FechasExamenes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryFechasExamenes extends MongoRepository<FechasExamenes,String> {
}
