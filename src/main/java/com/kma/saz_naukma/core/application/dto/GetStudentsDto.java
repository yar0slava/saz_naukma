package com.kma.saz_naukma.core.application.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetStudentsDto {
    List<Long> studentsIds;
}
