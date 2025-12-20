package com.example.Final.ServiceTest;

import com.example.Final.dto.StudentDto;
import com.example.Final.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.Random;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    void getAllTest(){
        List<StudentDto> studentDtos = studentService.findAll();
        Assertions.assertNotNull(studentDtos);
        Assertions.assertNotEquals(0,studentDtos.size());
        for (int i = 0;i<studentDtos.size();i++){
            StudentDto studentDto = studentDtos.get(i);
            Assertions.assertNotNull(studentDto.getId());
            Assertions.assertNotNull(studentDto.getFirstName());
            Assertions.assertNotNull(studentDto.getLastName());
            Assertions.assertNotNull(studentDto.getEmail());
            Assertions.assertNotNull(studentDto.getAge());
        }
    }
    @Test
    void findById(){
        Random random = new Random();
        int RandomIndex = random.nextInt(studentService.findAll().size());
        Long someId = studentService.findAll().get(RandomIndex).getId();

        StudentDto studentDto = studentService.findById(someId);

        Assertions.assertNotNull(studentDto.getFirstName());
        Assertions.assertNotNull(studentDto.getLastName());
        Assertions.assertNotNull(studentDto.getEmail());
        Assertions.assertNotNull(studentDto.getAge());

        StudentDto check = studentService.findById(-1L);
        Assertions.assertNull(check);

    }
    @Test
    void saveStudentTest(){
        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName("Birzhan");
        studentDto.setLastName("Sovetov");
        studentDto.setEmail("birzhan@gmail.com");
        studentDto.setAge(20);

        StudentDto createdStudent = studentService.saveStudent(studentDto);
        Assertions.assertNotNull(createdStudent);
        Assertions.assertNotNull(createdStudent.getId());
        Assertions.assertNotNull(studentDto.getFirstName());
        Assertions.assertNotNull(studentDto.getLastName());
        Assertions.assertNotNull(studentDto.getEmail());
        Assertions.assertNotNull(studentDto.getAge());

        Assertions.assertEquals(studentDto.getFirstName(),createdStudent.getFirstName());
        Assertions.assertEquals(studentDto.getLastName(),createdStudent.getLastName());
        Assertions.assertEquals(studentDto.getEmail(),createdStudent.getEmail());
        Assertions.assertEquals(studentDto.getAge(),createdStudent.getAge());
        StudentDto getStudent = studentService.findById(createdStudent.getId());

        Assertions.assertNotNull(getStudent);
        Assertions.assertNotNull(getStudent.getId());
        Assertions.assertNotNull(getStudent.getFirstName());
        Assertions.assertNotNull(getStudent.getLastName());
        Assertions.assertNotNull(getStudent.getEmail());
        Assertions.assertNotNull(getStudent.getAge());

        Assertions.assertEquals(createdStudent.getId(),getStudent.getId());
        Assertions.assertEquals(createdStudent.getFirstName(),getStudent.getFirstName());
        Assertions.assertEquals(createdStudent.getLastName(),getStudent.getLastName());
        Assertions.assertEquals(createdStudent.getEmail(),getStudent.getEmail());
        Assertions.assertEquals(createdStudent.getAge(),getStudent.getAge());
    }


    @Test
    void updateCategoryTest(){
        Random random = new Random();
        int RandomIndex = random.nextInt(studentService.findAll().size());
        Long someId = studentService.findAll().get(RandomIndex).getId();
        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName("Birzhan");
        studentDto.setLastName("Sovetov");
        studentDto.setEmail("birzhan@gmail.com");
        studentDto.setAge(20);


        StudentDto beforeUpdate = studentService.updateStudent(someId,studentDto);
        Assertions.assertNotNull(beforeUpdate);
        Assertions.assertNotNull(beforeUpdate.getId());
        Assertions.assertNotNull(beforeUpdate.getFirstName());
        Assertions.assertNotNull(beforeUpdate.getLastName());
        Assertions.assertNotNull(beforeUpdate.getEmail());
        Assertions.assertNotNull(beforeUpdate.getAge());

        Assertions.assertEquals(studentDto.getFirstName(),beforeUpdate.getFirstName());
        Assertions.assertEquals(studentDto.getLastName(),beforeUpdate.getLastName());
        Assertions.assertEquals(studentDto.getEmail(),beforeUpdate.getEmail());
        Assertions.assertEquals(studentDto.getAge(),beforeUpdate.getAge());

        StudentDto afterUpdate = studentService.findById(someId);
        Assertions.assertNotNull(afterUpdate);
        Assertions.assertNotNull(afterUpdate.getId());
        Assertions.assertNotNull(afterUpdate.getFirstName());
        Assertions.assertNotNull(afterUpdate.getLastName());
        Assertions.assertNotNull(afterUpdate.getEmail());
        Assertions.assertNotNull(afterUpdate.getAge());

        Assertions.assertEquals(beforeUpdate.getId(),afterUpdate.getId());
        Assertions.assertEquals(beforeUpdate.getFirstName(),afterUpdate.getFirstName());
        Assertions.assertEquals(beforeUpdate.getLastName(),afterUpdate.getLastName());
        Assertions.assertEquals(beforeUpdate.getEmail(),afterUpdate.getEmail());
        Assertions.assertEquals(beforeUpdate.getAge(),afterUpdate.getAge());

    }
    @Test
    void deleteCategoryTest(){
        Random random = new Random();
        int RandomIndex = random.nextInt(studentService.findAll().size());
        Long someId = studentService.findAll().get(RandomIndex).getId();
        Assertions.assertTrue(studentService.deleteById(someId));
        StudentDto studentDto = studentService.findById(someId);
        Assertions.assertNull(studentDto);
    }
}
