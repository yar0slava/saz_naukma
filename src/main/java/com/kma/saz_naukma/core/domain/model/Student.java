package com.kma.saz_naukma.core.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String surname;
    private String secondName;
    private String faculty;
    private String specialization;
    private String level;
    private String studyYear;
}
