package com.example.Final.MapperTest;

import com.example.Final.dto.CourseDto;
import com.example.Final.dto.StudentDto;
import com.example.Final.dto.SubjectDto;
import com.example.Final.entity.Course;
import com.example.Final.entity.Student;
import com.example.Final.entity.Subject;
import com.example.Final.mapper.StudentMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;


    @Test
    void convertEntityToDto(){
        List<Subject> subjects = new ArrayList<>();
        Course course = new Course();
        Student student = new Student(1L, "Aruzhan", "Kadyrova", "a@mail.com", 20,course,subjects);
        StudentDto  studentDto = studentMapper.toDto(student);

        Assertions.assertNotNull(studentDto);
        Assertions.assertNotNull(studentDto.getId());
        Assertions.assertNotNull(studentDto.getFirstName());
        Assertions.assertNotNull(studentDto.getLastName());
        Assertions.assertNotNull(studentDto.getEmail());
        Assertions.assertNotNull(studentDto.getAge());

        Assertions.assertEquals(student.getId(),studentDto.getId());
        Assertions.assertEquals(student.getFirstName(),studentDto.getFirstName());
        Assertions.assertEquals(student.getLastName(),studentDto.getLastName());
        Assertions.assertEquals(student.getEmail(),studentDto.getEmail());
        Assertions.assertEquals(student.getAge(),studentDto.getAge());
    }

    @Test
    void convertDtoToEntity(){
        List<SubjectDto> subjectsDto = new ArrayList<>();
        CourseDto courseDto = new CourseDto();
        StudentDto studentDto = new StudentDto(1L, "Aruzhan", "Kadyrova", "a@mail.com", 20,courseDto,subjectsDto);

        Student student = studentMapper.toEntity(studentDto);

        Assertions.assertNotNull(student);
        Assertions.assertNotNull(student.getId());
        Assertions.assertNotNull(student.getFirstName());
        Assertions.assertNotNull(student.getLastName());
        Assertions.assertNotNull(student.getEmail());
        Assertions.assertNotNull(student.getAge());

        Assertions.assertEquals(studentDto.getId(),student.getId());
        Assertions.assertEquals(studentDto.getFirstName(),student.getFirstName());
        Assertions.assertEquals(studentDto.getLastName(),student.getLastName());
        Assertions.assertEquals(studentDto.getEmail(),student.getEmail());
        Assertions.assertEquals(studentDto.getAge(),student.getAge());

    }
    @Test
    void ConvertEntityListToDtoList(){
        List<Subject> subjects = new ArrayList<>();
        Course course = new Course();
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "Aruzhan", "Kadyrova", "a@mail.com", 20,course,subjects));
        students.add(new Student(2L, "Aizhan", "Kadyrbekova", "a@mail.com", 19,course,subjects));

        List<StudentDto> studentDtos = studentMapper.toDtoList(students);
        Assertions.assertNotNull(studentDtos);
        Assertions.assertNotEquals(0,studentDtos.size());
        Assertions.assertEquals(students.size(),studentDtos.size());

        for (int i = 0;i<studentDtos.size();i++){
            Student student = students.get(i);
            StudentDto studentDto = studentMapper.toDto(student);

            Assertions.assertNotNull(studentDto);
            Assertions.assertNotNull(studentDto.getId());
            Assertions.assertNotNull(studentDto.getFirstName());
            Assertions.assertNotNull(studentDto.getLastName());
            Assertions.assertNotNull(studentDto.getEmail());
            Assertions.assertNotNull(studentDto.getAge());

        }



    }

}
