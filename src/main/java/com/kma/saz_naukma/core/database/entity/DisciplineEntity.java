package com.kma.saz_naukma.core.database.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@ToString
@Document(collection = "discipline")
public class DisciplineEntity {
    @Id
    private String id;


    private Long code;
    private String annotation;
    private Integer approvedGroupsAmount;
    private String creditType;
    private Double creditsAmount;
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
