package com.example.nuevaprueba.repository;

import com.example.nuevaprueba.entitys.MateriaCursando;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReposotoryMateriaCursando extends CrudRepository<MateriaCursando,String> {
}
