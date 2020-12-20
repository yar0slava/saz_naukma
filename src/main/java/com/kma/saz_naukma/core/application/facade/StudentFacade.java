package com.kma.saz_naukma.core.application.facade;

import com.kma.saz_naukma.core.application.dto.GetStudentsDto;
import com.kma.saz_naukma.core.application.dto.StudentDto;
import com.kma.saz_naukma.core.domain.model.Student;
import com.kma.saz_naukma.core.domain.service.StudentService;
import com.kma.saz_naukma.core.mapper.StudentMapper;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentFacade {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public StudentFacade(StudentService studentService, StudentMapper studentMapper){
        this.studentMapper = studentMapper;
        this.studentService = studentService;
    }

    public List<StudentDto> getAll(List<Long> ids) {
        return studentService.getAllByIds(ids).stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<StudentDto> getAll() {
        return studentService.getAllByIds().stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    public StudentDto getById(Long id) throws NotFoundException {
        Student student = studentService.getStudentById(id);
        return studentMapper.toDto(student);
    }

    public StudentDto getByEmail(String studentEmail) throws NotFoundException {
        Student student = studentService.getByEmail(studentEmail);
        return studentMapper.toDto(student);
    }

    public StudentDto addStudent(StudentDto studentDto) {
        Student student = studentService.addStudent(studentMapper.fromDtoToModel(studentDto));
        return studentMapper.toDto(student);
    }
}
