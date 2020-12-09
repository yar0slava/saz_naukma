package com.kma.saz_naukma.core.database.repository;

import com.kma.saz_naukma.core.database.entity.StudentEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface StudentRepository extends PagingAndSortingRepository<StudentEntity,Long> {

    Optional<StudentEntity> getById(Long id);

    Optional<StudentEntity>  getByEmail(String studentEmail);

    Iterable<StudentEntity> findAll();

    Iterable<StudentEntity> findAllById(Iterable<Long> ids);
}
