package com.example.Final.mapper;

import com.example.Final.dto.StudentDto;
import com.example.Final.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDto toDto(Student student);
    Student toEntity(StudentDto dto);

    List<StudentDto> toDtoList(List<Student> students);
    List<Student> toEntityList(List<StudentDto> dtos);


}

