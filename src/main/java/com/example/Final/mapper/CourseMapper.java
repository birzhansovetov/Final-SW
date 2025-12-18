package com.example.Final.mapper;

import com.example.Final.dto.CourseDto;
import com.example.Final.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDto toDto(Course course);

    Course toEntity(CourseDto dto);
    List<CourseDto> toDtoList(List<Course> courses);
    List<Course> toEntityList(List<CourseDto> dtos);
}
