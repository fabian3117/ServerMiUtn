package com.example.nuevaprueba.repository;

import com.example.nuevaprueba.entitys.Perfil;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryPerfil extends MongoRepository<Perfil,String> {
    Optional<Perfil> findByUserName(String name);
    Optional<Perfil> findByCorreoInstitucional(String correo);
    Optional<Perfil>  findOneByCorreoInstitucional(String correo);
    Optional<Perfil> findPerfilByCorreoInstitucional(String correo);
}
