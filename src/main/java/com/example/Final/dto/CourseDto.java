package com.example.Final.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CourseDto {
    private Long id;
    private String name;
    private String description;
}
