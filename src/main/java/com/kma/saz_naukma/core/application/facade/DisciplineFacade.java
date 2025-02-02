package com.kma.saz_naukma.core.application.facade;

import com.kma.saz_naukma.core.application.dto.DisciplineDto;
import com.kma.saz_naukma.core.application.dto.GetDisciplinesDto;
import com.kma.saz_naukma.core.application.dto.PageDto;
import com.kma.saz_naukma.core.domain.model.Discipline;
import com.kma.saz_naukma.core.domain.service.DisciplineService;
import com.kma.saz_naukma.core.mapper.DisciplineMapper;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DisciplineFacade {

    DisciplineService disciplineService;
    DisciplineMapper disciplineMapper;

    DisciplineFacade(DisciplineService disciplineService, DisciplineMapper disciplineMapper){
        this.disciplineMapper = disciplineMapper;
        this.disciplineService = disciplineService;
    }


    public DisciplineDto findByCode(Long discId) throws NotFoundException {
        Discipline discipline = disciplineService.findByCode(discId);
        return disciplineMapper.toDto(discipline);
    }

    public List<DisciplineDto> getAll() {
        return disciplineService.getAll().stream()
                .map(disciplineMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<DisciplineDto> getFiltered(GetDisciplinesDto disciplinesDto) {
        return disciplineService.getFiltered(disciplinesDto).stream()
                .map(disciplineMapper::toDto)
                .collect(Collectors.toList());
    }

    public PageDto<DisciplineDto> getFilteredPaged(GetDisciplinesDto disciplinesDto, Integer page, Integer size) {
        List<DisciplineDto> list = disciplineService.getFilteredPaged(disciplinesDto, page, size).stream()
                .map(disciplineMapper::toDto)
                .collect(Collectors.toList());
        return new PageDto<>(list.size(), list);
    }
}
