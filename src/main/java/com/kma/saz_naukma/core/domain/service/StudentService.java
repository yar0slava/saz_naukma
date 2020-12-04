package com.kma.saz_naukma.core.domain.service;

import com.kma.saz_naukma.core.database.repository.StudentRepository;
import com.kma.saz_naukma.core.domain.model.Student;
import com.kma.saz_naukma.core.mapper.StudentMapper;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

//@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper stusentMapper){
        this.studentRepository = studentRepository;
        this.studentMapper = stusentMapper;
    }

    public Student getStudent(Long id) throws NotFoundException{
        Optional<Student> student = studentRepository.findById(id).map(studentMapper::toModel);
        return student.orElseThrow(() -> new NotFoundException(String.format("Student not found with id %s",id)));
    }
}
