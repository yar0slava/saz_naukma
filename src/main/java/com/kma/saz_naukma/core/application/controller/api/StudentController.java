package com.kma.saz_naukma.core.application.controller.api;

import com.kma.saz_naukma.core.application.dto.StudentDto;
import com.kma.saz_naukma.core.application.facade.StudentFacade;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/api/students")
public class StudentController {

    private final StudentFacade studentFacade;

    public StudentController(StudentFacade studentFacade){
        this.studentFacade = studentFacade;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDto getStudent(@PathVariable("id") Long studentId) throws NotFoundException {
        return studentFacade.getStudent(studentId);
    }
}
