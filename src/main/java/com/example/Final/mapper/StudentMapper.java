package com.example.Final.mapper;

import com.example.Final.dto.StudentDto;
import com.example.Final.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "subjects", target = "subjectIds")
    StudentDto toDto(Student student);

    @Mapping(source = "courseId", target = "course")
    @Mapping(source = "subjectIds", target = "subjects")
    Student toEntity(StudentDto dto);

    List<StudentDto> toDtoList(List<Student> students);
    List<Student> toEntityList(List<StudentDto> dtos);


}

