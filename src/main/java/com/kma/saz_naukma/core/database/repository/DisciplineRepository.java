package com.kma.saz_naukma.core.database.repository;

import com.kma.saz_naukma.core.database.entity.DisciplineEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DisciplineRepository extends MongoRepository<DisciplineEntity, String> {

    Optional<DisciplineEntity> findByCode(Long id);


}
