package com.kma.saz_naukma.core.application.facade;

import com.kma.saz_naukma.core.application.dto.StudentDto;
import com.kma.saz_naukma.core.domain.model.Student;
import com.kma.saz_naukma.core.domain.service.StudentService;
import com.kma.saz_naukma.core.mapper.StudentMapper;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;

//@Component
public class StudentFacade {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public StudentFacade(StudentService studentService, StudentMapper studentMapper){
        this.studentMapper = studentMapper;
        this.studentService = studentService;
    }

    public StudentDto getStudent(Long id) throws NotFoundException {
        Student student = studentService.getStudent(id);
        return studentMapper.toDto(student);
    }
}
