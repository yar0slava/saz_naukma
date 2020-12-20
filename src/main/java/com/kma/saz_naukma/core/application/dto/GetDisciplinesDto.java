package com.kma.saz_naukma.core.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class GetDisciplinesDto {

    private String name;
    private String lector;
    private List<String> studyingYear;    //навч рік
    private List<String> level;
    private List<Integer> creditsAmount;
    private List<String> yearOfStudying;  // курс
    private List<String> recommendation;
    private List<String> faculty;
    private String specialization;
    private List<String> enrollmentType;
}
