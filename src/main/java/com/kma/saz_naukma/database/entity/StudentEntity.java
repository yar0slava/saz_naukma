package com.kma.saz_naukma.database.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "faculty", nullable = false)
    private String faculty;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "level", nullable = false)
    private String level;

    @Column(name = "study_year", nullable = false)
    private String studyYear;
}
