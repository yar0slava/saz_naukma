package com.kma.saz_naukma.core.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DisciplineDto {

    private String id;
    private Long code;
    private String annotation;
    private Integer approvedGroupsAmount;
    private String creditType;
    private Integer creditsAmount;
    private String department;
    private Integer enrolledStudentsAmount;
    private String faculty;
    private Double hoursPerWeek;
    private String lector;
    private String level;
    private Integer maxGroups;
    private Integer maxStudInGroup;
    private Integer minStudInGroup;
    private Integer remainingPlacesAmount;
    private String semester;
    private String studyingYear;
    private List<Integer> studentsIDs;
}
