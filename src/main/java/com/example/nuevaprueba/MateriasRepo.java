package com.example.nuevaprueba;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MateriasRepo extends JpaRepository<Materias, Long> {
    //-->   Si existe algun elemento con id no nulo significa que tenemos dato  <--
   // boolean existsByIdIsNotEmpty();
}
