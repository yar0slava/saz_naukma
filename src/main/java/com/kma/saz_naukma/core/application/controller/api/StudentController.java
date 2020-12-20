package com.kma.saz_naukma.core.application.controller.api;

import com.kma.saz_naukma.core.application.dto.GetStudentsDto;
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
    //  +student by id;
    //  +student by email;
    //  student update;
    //  student add;
    //  +students by id array/list;
    //  enroll to discipline

    private final StudentFacade studentFacade;

    public StudentController(StudentFacade studentFacade){
        this.studentFacade = studentFacade;
    }

    @CrossOrigin
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDto> getStudent() {
        return studentFacade.getAll();
    }

    @CrossOrigin
    @GetMapping("/ids")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDto> getStudentsByIds(@RequestBody List<Long> ids) {
        return studentFacade.getAll(ids);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDto getStudentById(@PathVariable("id") Long studentId) throws NotFoundException {
        return studentFacade.getById(studentId);
    }

    @CrossOrigin
    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDto getStudentByEmail(@PathVariable("email") String studentEmail) throws NotFoundException {
        return studentFacade.getByEmail(studentEmail);
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto addStudent(@RequestBody StudentDto studentDto){
        return studentFacade.addStudent(studentDto);
    }

//    @CrossOrigin
//    @PostMapping("/enroll")
//    @ResponseStatus(HttpStatus.OK)
//    public StudentDto enrollStudent(@RequestBody List<Long> ids) {
////        return studentFacade.getAll(ids);
//        return new StudentDto();
//    }
}
