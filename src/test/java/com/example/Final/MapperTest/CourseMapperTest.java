package com.example.Final.MapperTest;

import com.example.Final.dto.CourseDto;
import com.example.Final.entity.Course;
import com.example.Final.mapper.CourseMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CourseMapperTest {
    @Autowired
    private CourseMapper courseMapper;

    @Test
    void convertEntityToDto(){
        Course course = new Course(1L, "Java Developer","spring");
        CourseDto courseDto = courseMapper.toDto(course);

        Assertions.assertNotNull(courseDto);
        Assertions.assertNotNull(courseDto.getId());
        Assertions.assertNotNull(courseDto.getName());
        Assertions.assertNotNull(courseDto.getDescription());

        Assertions.assertEquals(course.getId(),courseDto.getId());
        Assertions.assertEquals(course.getName(),courseDto.getName());
        Assertions.assertEquals(course.getDescription(),courseDto.getDescription());
    }

    @Test
    void convertDtoToEntity(){
        CourseDto courseDto = new CourseDto(1L,"Java Developer","something");
        Course course = courseMapper.toEntity(courseDto);

        Assertions.assertNotNull(course);
        Assertions.assertNotNull(course.getId());
        Assertions.assertNotNull(course.getName());
        Assertions.assertNotNull(course.getDescription());

        Assertions.assertEquals(courseDto.getId(),course.getId());
        Assertions.assertEquals(courseDto.getName(),course.getName());
        Assertions.assertEquals(courseDto.getDescription(),course.getDescription());
    }

    @Test
    void convertConvertEntityListToDtoList(){
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1L, "Java Developer","spring"));
        courses.add(new Course(2L, "Front-end Developer","React"));
        courses.add(new Course(3L, "Go Developer","Rest"));

        List<CourseDto> courseDtos = courseMapper.toDtoList(courses);

        Assertions.assertNotNull(courseDtos);
        Assertions.assertNotEquals(0,courseDtos.size());
        Assertions.assertEquals(courses.size(),courseDtos.size());

        for (int i=0;i<courseDtos.size(); i++){
            Course course = courses.get(i);
            CourseDto courseDto = courseMapper.toDto(course);

            Assertions.assertNotNull(courseDto);
            Assertions.assertNotNull(courseDto.getId());
            Assertions.assertNotNull(courseDto.getName());
            Assertions.assertNotNull(courseDto.getDescription());
        }
    }
}
