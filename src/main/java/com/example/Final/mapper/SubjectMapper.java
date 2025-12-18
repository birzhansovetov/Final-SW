package com.example.Final.mapper;

import com.example.Final.dto.SubjectDto;
import com.example.Final.entity.Subject;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    SubjectDto toDto(Subject subject);
    Subject toEntity(SubjectDto dto);

    List<SubjectDto> toDtoList(List<Subject> subjects);
    List<Subject> toEntityList(List<SubjectDto> dtos);
}
