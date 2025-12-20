package com.example.Final.MapperTest;

import com.example.Final.dto.CourseDto;
import com.example.Final.dto.SubjectDto;
import com.example.Final.entity.Course;
import com.example.Final.entity.Subject;
import com.example.Final.mapper.SubjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SubjectMapperTest {
    @Autowired
    private SubjectMapper subjectMapper;

    @Test
    void ConvertEntityToDto(){
        Subject subject = new Subject(1L,"Java");
        SubjectDto subjectDto = subjectMapper.toDto(subject);

        Assertions.assertNotNull(subjectDto);
        Assertions.assertNotNull(subjectDto.getId());
        Assertions.assertNotNull(subjectDto.getName());

        Assertions.assertEquals(subject.getId(),subjectDto.getId());
        Assertions.assertEquals(subject.getName(),subjectDto.getName());

    }
    @Test
    void ConvertDtoToEntity(){
        SubjectDto subjectDto = new SubjectDto(1L,"JAVA");
        Subject subject = subjectMapper.toEntity(subjectDto);

        Assertions.assertNotNull(subject);
        Assertions.assertNotNull(subject.getId());
        Assertions.assertNotNull(subject.getName());

        Assertions.assertEquals(subjectDto.getId(),subject.getId());
        Assertions.assertEquals(subjectDto.getName(),subject.getName());
    }

    @Test
    void ConvertEntityListToDtoList(){
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(1L,"Java"));
        subjects.add(new Subject(1L,"React"));
        subjects.add(new Subject(1L,"Rest"));

        List<SubjectDto> subjectDtos = subjectMapper.toDtoList(subjects);
        Assertions.assertNotNull(subjectDtos);
        Assertions.assertNotEquals(0,subjectDtos.size());
        Assertions.assertEquals(subjects.size(),subjectDtos.size());

        for (int i=0;i<subjectDtos.size(); i++){
            Subject subject = subjects.get(i);
            SubjectDto subjectDto= subjectMapper.toDto(subject);

            Assertions.assertNotNull(subjectDto);
            Assertions.assertNotNull(subjectDto.getId());
            Assertions.assertNotNull(subjectDto.getName());
        }
    }
}
