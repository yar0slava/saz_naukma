package com.kma.saz_naukma.core.domain.service;

import com.kma.saz_naukma.core.database.repository.DisciplineRepository;
import com.kma.saz_naukma.core.domain.model.Discipline;
import com.kma.saz_naukma.core.mapper.DisciplineMapper;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DisciplineService {

    DisciplineRepository disciplineRepository;
    DisciplineMapper disciplineMapper;

    DisciplineService(DisciplineRepository disciplineRepository, DisciplineMapper disciplineMapper) {
        this.disciplineMapper = disciplineMapper;
        this.disciplineRepository = disciplineRepository;
    }

    public Discipline findByCode(Long discId) throws NotFoundException {
        Optional<Discipline> discipline = disciplineRepository.findByCode(discId).map(disciplineMapper::toModel);
        return discipline.orElseThrow(() -> new NotFoundException(String.format("Discipline not found with code %s", discId)));

    }

    public List<Discipline> getAll() {
        return StreamSupport.stream(disciplineRepository.findAll().spliterator(),false)
                .map(disciplineMapper::toModel)
                .collect(Collectors.toList());
    }
}
