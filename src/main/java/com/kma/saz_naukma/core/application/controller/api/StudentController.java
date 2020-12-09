package com.kma.saz_naukma.core.application.controller.api;

import com.kma.saz_naukma.core.application.dto.StudentDto;
import com.kma.saz_naukma.core.application.facade.StudentFacade;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    // TODO;
    //  student by id;
    //  student by email;
    //  student update;
    //  student add;
    //  students by id array/list;
    //  enroll to discipline

    private final StudentFacade studentFacade;

    public StudentController(StudentFacade studentFacade){
        this.studentFacade = studentFacade;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDto> getStudent() {
        return studentFacade.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDto getStudentById(@PathVariable("id") Long studentId) throws NotFoundException {
        return studentFacade.getById(studentId);
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDto getStudentByEmail(@PathVariable("email") String studentEmail) throws NotFoundException {
        return studentFacade.getByEmail(studentEmail);
    }
}
