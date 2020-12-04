package com.kma.saz_naukma.core.database.repository;

import com.kma.saz_naukma.core.database.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<StudentEntity,Long> {

    Optional<StudentEntity> findById(Long id);

    Optional<StudentEntity> findByEmail(String email);

}
