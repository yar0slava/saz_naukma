package com.kma.saz_naukma.core.application.controller.api;

import com.kma.saz_naukma.core.application.dto.DisciplineDto;
import com.kma.saz_naukma.core.application.dto.GetDisciplinesDto;
import com.kma.saz_naukma.core.application.dto.PageDto;
import com.kma.saz_naukma.core.application.facade.DisciplineFacade;
import javassist.NotFoundException;
import javassist.tools.web.BadHttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController {

    // TODO;
    //  +discipline by code;
    //  discipline update;
    //  discipline add;
    //  discipline filtering
    //  discipline pagination

    private final DisciplineFacade disciplineFacade;

    public DisciplineController(DisciplineFacade disciplineFacade){
        this.disciplineFacade = disciplineFacade;
    }

    @CrossOrigin
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DisciplineDto> getAll(){
        return disciplineFacade.getAll();
    }

    @CrossOrigin
    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public DisciplineDto getDiscipline(@PathVariable Long code) throws NotFoundException {
        return disciplineFacade.findByCode(code);
    }

//    @GetMapping("/filtered")
//    @ResponseStatus(HttpStatus.OK)
//    public List<DisciplineDto> getDisciplinesFiltered(@RequestBody GetDisciplinesDto disciplinesDto) throws BadHttpRequest {
//        return disciplineFacade.getFiltered(disciplinesDto);
//    }

    @CrossOrigin
    @GetMapping("/filtered")
    @ResponseStatus(HttpStatus.OK)
    public PageDto<DisciplineDto> getDisciplinesFilteredPaged(@RequestParam(value = "page", required = false) Integer page,
                                                              @RequestParam(value = "size", required = false) Integer size,
                                                              @RequestParam(value = "name", required = false) String name,
                                                              @RequestParam(value = "lector", required = false) String lector,
                                                              @RequestParam(value = "studyingYear", required = false) List<String> studyingYear,
                                                              @RequestParam(value = "level", required = false) List<String> level,
                                                              @RequestParam(value = "creditsAmount", required = false) List<Integer> creditsAmount,
                                                              @RequestParam(value = "yearOfStudying", required = false) List<String> yearOfStudying,
                                                              @RequestParam(value = "recommendation", required = false) List<String> recommendation,
                                                              @RequestParam(value = "faculty", required = false) List<String> faculty,
                                                              @RequestParam(value = "specialization", required = false) String specialization,
                                                              @RequestParam(value = "enrollmentType", required = false) List<String> enrollmentType) throws BadHttpRequest {
        PageDto<DisciplineDto> paged = disciplineFacade.getFilteredPaged(new GetDisciplinesDto(name,lector,studyingYear,level,creditsAmount,
                yearOfStudying,recommendation,faculty,specialization,enrollmentType), page, size);
//        System.out.println(paged);
        return  paged;
    }
}
