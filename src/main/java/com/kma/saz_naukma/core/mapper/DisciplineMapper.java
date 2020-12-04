package com.kma.saz_naukma.core.mapper;

import com.kma.saz_naukma.core.application.dto.DisciplineDto;
import com.kma.saz_naukma.core.database.entity.DisciplineEntity;
import com.kma.saz_naukma.core.domain.model.Discipline;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DisciplineMapper {
    private final ModelMapper mapper;

    public DisciplineMapper(ModelMapper modelMapper){
        this.mapper = modelMapper;
    }

    public DisciplineDto toDto(Discipline discipline){
        return Objects.isNull(discipline) ? null : mapper.map(discipline, DisciplineDto.class);
    }

    public Discipline toModel(DisciplineEntity disciplineEntity){
        return Objects.isNull(disciplineEntity) ? null : mapper.map(disciplineEntity, Discipline.class);
    }

}
