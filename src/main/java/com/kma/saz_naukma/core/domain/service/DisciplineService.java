package com.kma.saz_naukma.core.domain.service;

import com.kma.saz_naukma.core.application.dto.GetDisciplinesDto;
import com.kma.saz_naukma.core.database.repository.DisciplineRepository;
import com.kma.saz_naukma.core.domain.model.Discipline;
import com.kma.saz_naukma.core.mapper.DisciplineMapper;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DisciplineService {

    @Autowired
    MongoTemplate mongoTemplate;
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

    public List<Discipline> getFiltered(GetDisciplinesDto disciplinesDto) {
        Query query = new Query();

        if(disciplinesDto.getName() != null){
            query.addCriteria(Criteria.where("name").regex(disciplinesDto.getName()));
        }
        if(disciplinesDto.getLector() != null){
            query.addCriteria(Criteria.where("lector").regex(disciplinesDto.getLector()));
        }
        if(disciplinesDto.getStudyingYear() != null){
            query.addCriteria(Criteria.where("studyingYear").in(disciplinesDto.getStudyingYear()));
        }
        if(disciplinesDto.getLevel() != null){
            query.addCriteria(Criteria.where("level").in(disciplinesDto.getLevel()));
        }
        if(disciplinesDto.getCreditsAmount() != null){
            query.addCriteria(Criteria.where("creditsAmount").in(disciplinesDto.getCreditsAmount()));
        }
        if(disciplinesDto.getYearOfStudying() != null){
            query.addCriteria(Criteria.where("yearOfStudying").in(disciplinesDto.getYearOfStudying()));
        }
        if(disciplinesDto.getRecommendation() != null){
            query.addCriteria(Criteria.where("recommendation").in(disciplinesDto.getRecommendation()));
        }
        if(disciplinesDto.getFaculty() != null){
            query.addCriteria(Criteria.where("faculty").in(disciplinesDto.getFaculty()));
        }
        if(disciplinesDto.getSpecialization() != null){
            query.addCriteria(Criteria.where("specialization").regex(disciplinesDto.getSpecialization()));
        }
        if(disciplinesDto.getEnrollmentType() != null){
            query.addCriteria(Criteria.where("enrollmentType").in(disciplinesDto.getEnrollmentType()));
        }
        return mongoTemplate.find(query,Discipline.class);
    }

    public Page<Discipline> getFilteredPaged(GetDisciplinesDto disciplinesDto, Integer page, Integer size) {
        Query query = new Query();

        if(disciplinesDto.getName() != null){
            query.addCriteria(Criteria.where("name").regex(disciplinesDto.getName()));
        }
        if(disciplinesDto.getLector() != null){
            query.addCriteria(Criteria.where("lector").regex(disciplinesDto.getLector()));
        }
        if(disciplinesDto.getStudyingYear() != null){
            query.addCriteria(Criteria.where("studyingYear").in(disciplinesDto.getStudyingYear()));
        }
        if(disciplinesDto.getLevel() != null){
            query.addCriteria(Criteria.where("level").in(disciplinesDto.getLevel()));
        }
        if(disciplinesDto.getCreditsAmount() != null){
            query.addCriteria(Criteria.where("creditsAmount").in(disciplinesDto.getCreditsAmount()));
        }
        if(disciplinesDto.getYearOfStudying() != null){
            query.addCriteria(Criteria.where("yearOfStudying").in(disciplinesDto.getYearOfStudying()));
        }
        if(disciplinesDto.getRecommendation() != null){
            query.addCriteria(Criteria.where("recommendation").in(disciplinesDto.getRecommendation()));
        }
        if(disciplinesDto.getFaculty() != null){
            query.addCriteria(Criteria.where("faculty").in(disciplinesDto.getFaculty()));
        }
        if(disciplinesDto.getSpecialization() != null){
            query.addCriteria(Criteria.where("specialization").regex(disciplinesDto.getSpecialization()));
        }
        if(disciplinesDto.getEnrollmentType() != null){
            query.addCriteria(Criteria.where("enrollmentType").in(disciplinesDto.getEnrollmentType()));
        }

        if(size == null){
            size = 10;
        }
        if(page == null){
            page = 0;
        }

        Pageable pageRequest = PageRequest.of(page, size);
        query.with(pageRequest);
        List list = mongoTemplate.find(query, Discipline.class);
        return PageableExecutionUtils.getPage(
                list,
                pageRequest,
                () -> mongoTemplate.count(query, Discipline.class));
    }
}
