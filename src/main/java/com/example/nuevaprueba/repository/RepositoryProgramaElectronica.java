package com.example.nuevaprueba.repository;

import com.example.nuevaprueba.entitys.ProgramaElectronica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProgramaElectronica extends CrudRepository<ProgramaElectronica,String> {
}
