package com.kma.saz_naukma.core.mapper;

import com.kma.saz_naukma.core.application.dto.StudentDto;
import com.kma.saz_naukma.core.database.entity.StudentEntity;
import com.kma.saz_naukma.core.domain.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StudentMapper {

    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;

    public StudentMapper(PasswordEncoder passwordEncoder, ModelMapper modelMapper){
        this.passwordEncoder = passwordEncoder;
        this.mapper = modelMapper;
    }

//    public StudentMapper(ModelMapper modelMapper){
//        this.mapper = modelMapper;
//    }

    public StudentDto toDto(Student student){
        return Objects.isNull(student) ? null : mapper.map(student, StudentDto.class);
    }

    public Student toModel(StudentEntity studentEntity){
        return Objects.isNull(studentEntity) ? null : mapper.map(studentEntity, Student.class);
    }

    public Student fromDtoToModel(StudentDto studentDto){
        return Objects.isNull(studentDto) ? null : mapper.map(studentDto, Student.class);
    }

    public StudentEntity toEntity(Student student){
        StudentEntity studentEntity = mapper.map(student, StudentEntity.class);
        studentEntity.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentEntity;
    }
}
