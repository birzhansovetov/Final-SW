package com.example.Final.service;

import com.example.Final.dto.CourseDto;
import com.example.Final.entity.Course;
import com.example.Final.entity.Student;
import com.example.Final.mapper.CourseMapper;
import com.example.Final.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;


    public List<CourseDto> findAll() {
        return courseMapper.toDtoList(courseRepository.findAll());
    }

    public CourseDto findById(Long id) {
        Course course = courseRepository.findById(id)
                .orElse(null);
        return courseMapper.toDto(course);
    }


    public CourseDto saveCourse(CourseDto dto) {
        Course saved = courseRepository.save(courseMapper.toEntity(dto));
        return courseMapper.toDto(saved);
    }

    public CourseDto update(Long id, CourseDto dto) {
        Course course = courseRepository.findById(id).orElse(null);

        course.setName(dto.getName());
        course.setDescription(dto.getDescription());

        Course saved = courseRepository.save(course);
        return courseMapper.toDto(saved);
    }

    public boolean deleteById(Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if(Objects.isNull(course)){
            return false;
        }
        courseRepository.deleteById(id);
        return true;
    }
}
