package com.example.Final.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private CourseDto course;
    private List<SubjectDto> subjects;
}
