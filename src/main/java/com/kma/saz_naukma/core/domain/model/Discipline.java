package com.kma.saz_naukma.core.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Discipline {
    private String id;  //?
    private Long code;
    private String annotation;

    private Integer enrolledStudentsAmount;
    private Integer approvedGroupsAmount;
    private Integer maxGroups;
    private Integer maxStudInGroup;
    private Integer minStudInGroup;
    private Integer remainingPlacesAmount;
    private Double hoursPerWeek;
//    private String creditType;
//    private String department;
//    private String semester;

    private String name;
    private String lector;
    private String studyingYear;    //навч рік
    private String level;
    private Integer creditsAmount;
    private String yearOfStudying;  // курс
    private String recommendation;
    private String faculty;
    private String specialization;
    private String enrollmentType;

    private List<Integer> studentsIDs;
}
