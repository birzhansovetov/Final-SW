package com.example.Final.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private Long courseId;
    private List<Long> subjectIds;
}
