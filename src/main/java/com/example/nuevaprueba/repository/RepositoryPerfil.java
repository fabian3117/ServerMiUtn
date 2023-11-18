package com.example.nuevaprueba.repository;

import com.example.nuevaprueba.entitys.Perfil;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPerfil extends MongoRepository<Perfil,String> {
}
