package com.kma.saz_naukma.core.domain.service;

import com.kma.saz_naukma.core.database.repository.StudentRepository;
import com.kma.saz_naukma.core.domain.model.Student;
import com.kma.saz_naukma.core.mapper.StudentMapper;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper stusentMapper){
        this.studentRepository = studentRepository;
        this.studentMapper = stusentMapper;
    }

    public Student getStudentById(Long id) throws NotFoundException{
        Optional<Student> student = studentRepository.getById(id).map(studentMapper::toModel);
        return student.orElseThrow(() -> new NotFoundException(String.format("Student not found with id %s",id)));
    }

    public List<Student> getAll() {
        return StreamSupport.stream(studentRepository.findAll().spliterator(), false)
                .map(studentMapper::toModel)
                .collect(Collectors.toList());
    }

    public Student getByEmail(String studentEmail) throws NotFoundException{
        Optional<Student> student = studentRepository.getByEmail(studentEmail).map(studentMapper::toModel);
        return student.orElseThrow(() -> new NotFoundException(String.format("Student not found with email %s",studentEmail)));
    }
}
