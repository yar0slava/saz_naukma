package com.kma.saz_naukma.core.mapper;

import com.kma.saz_naukma.core.application.dto.StudentDto;
import com.kma.saz_naukma.core.database.entity.StudentEntity;
import com.kma.saz_naukma.core.domain.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

//@Component
public class StudentMapper {

    private final ModelMapper mapper;

    public StudentMapper(ModelMapper modelMapper){
        this.mapper = modelMapper;
    }

    public StudentDto toDto(Student student){
        return Objects.isNull(student) ? null : mapper.map(student, StudentDto.class);
    }

    public Student toModel(StudentEntity studentEntity){
        return Objects.isNull(studentEntity) ? null : mapper.map(studentEntity, Student.class);
    }
}
