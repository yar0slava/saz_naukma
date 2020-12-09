package com.kma.saz_naukma.core.application.controller.api;

import com.kma.saz_naukma.core.application.dto.DisciplineDto;
import com.kma.saz_naukma.core.application.facade.DisciplineFacade;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController {

    // TODO;
    //  discipline by id;
    //  discipline update;
    //  discipline add;
    //  discipline filtering
    //  discipline pagination

    private final DisciplineFacade disciplineFacade;

    public DisciplineController(DisciplineFacade disciplineFacade){
        this.disciplineFacade = disciplineFacade;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DisciplineDto> getAll(){
        return disciplineFacade.getAll();
    }

    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public DisciplineDto getDiscipline(@PathVariable Long code) throws NotFoundException {
        return disciplineFacade.findByCode(code);
    }
}
