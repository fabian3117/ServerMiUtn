package com.example.nuevaprueba.repository;

import com.example.nuevaprueba.entitys.Materia;
import com.example.nuevaprueba.entitys.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProfile extends MongoRepository<Profile,String> {
    Materia findFirstByIdAndMateriaCursandosDia(String id, String dia);

    @Query("{'_id': ?0, 'materiaCursandos.dia': 'Lunes'}")
    Profile findUsuarioByDiaLunes(String id);
}
