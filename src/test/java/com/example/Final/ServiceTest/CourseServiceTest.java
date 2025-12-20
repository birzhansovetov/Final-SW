package com.example.Final.ServiceTest;

import com.example.Final.dto.CourseDto;
import com.example.Final.service.CourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class CourseServiceTest {
    @Autowired
    private CourseService courseService;
    @Test
    void getAllTest(){
        List<CourseDto> courseDtos = courseService.findAll();
        Assertions.assertNotNull(courseDtos);
        Assertions.assertNotEquals(0,courseDtos.size());
        for (int i = 0;i<courseDtos.size();i++){
            CourseDto courseDto = courseDtos.get(i);
            Assertions.assertNotNull(courseDto.getId());
            Assertions.assertNotNull(courseDto.getName());
            Assertions.assertNotNull(courseDto.getDescription());
        }
    }

    @Test
    void getByIdTest(){
        Random random = new Random();
        int RandomIndex = random.nextInt(courseService.findAll().size());
        Long someId = courseService.findAll().get(RandomIndex).getId();

        CourseDto courseDto = courseService.findById(someId);

        Assertions.assertNotNull(courseDto);
        Assertions.assertNotNull(courseDto.getId());
        Assertions.assertNotNull(courseDto.getName());
        Assertions.assertNotNull(courseDto.getDescription());

        CourseDto check = courseService.findById(-1L);
        Assertions.assertNull(check);

    }

    @Test
    void saveCourseTest(){
        CourseDto courseDto = new CourseDto();
        courseDto.setName("tech");
        courseDto.setDescription("something");

        CourseDto createdCourse = courseService.saveCourse(courseDto);
        Assertions.assertNotNull(createdCourse);
        Assertions.assertNotNull(createdCourse.getId());
        Assertions.assertNotNull(createdCourse.getName());
        Assertions.assertNotNull(createdCourse.getDescription());

        Assertions.assertEquals(courseDto.getName(),createdCourse.getName());
        Assertions.assertEquals(courseDto.getDescription(),createdCourse.getDescription());
        CourseDto getCourse = courseService.findById(createdCourse.getId());

        Assertions.assertNotNull(getCourse);
        Assertions.assertNotNull(getCourse.getId());
        Assertions.assertNotNull(getCourse.getName());
        Assertions.assertNotNull(getCourse.getDescription());
        Assertions.assertEquals(createdCourse.getId(),getCourse.getId());
        Assertions.assertEquals(createdCourse.getName(),getCourse.getName());
        Assertions.assertEquals(createdCourse.getDescription(),getCourse.getDescription());

    }

    @Test
    void updateTest(){
        Random random = new Random();
        int RandomIndex = random.nextInt(courseService.findAll().size());
        Long someId = courseService.findAll().get(RandomIndex).getId();

        CourseDto courseDto = new CourseDto();
        courseDto.setName("tech");
        courseDto.setDescription("something");

        CourseDto beforeUpdate = courseService.update(someId,courseDto);
        Assertions.assertNotNull(beforeUpdate);
        Assertions.assertNotNull(beforeUpdate.getId());
        Assertions.assertNotNull(beforeUpdate.getName());
        Assertions.assertNotNull(beforeUpdate.getDescription());

        Assertions.assertEquals(courseDto.getName(),beforeUpdate.getName());
        Assertions.assertEquals(courseDto.getDescription(),beforeUpdate.getDescription());

        CourseDto afterUpdate = courseService.findById(someId);
        Assertions.assertNotNull(afterUpdate);
        Assertions.assertNotNull(afterUpdate.getId());
        Assertions.assertNotNull(afterUpdate.getName());
        Assertions.assertNotNull(afterUpdate.getDescription());

        Assertions.assertEquals(beforeUpdate.getId(),afterUpdate.getId());
        Assertions.assertEquals(beforeUpdate.getName(),afterUpdate.getName());
        Assertions.assertEquals(beforeUpdate.getDescription(),afterUpdate.getDescription());

    }

    @Test
    void deleteCategoryTest(){
        CourseDto created = courseService.saveCourse(new CourseDto(null, "Temp course","Something"));
        Long id = created.getId();
        Assertions.assertNotNull(id);
        Assertions.assertTrue(courseService.deleteById(id));
        CourseDto courseDto = courseService.findById(id);
        Assertions.assertNull(courseDto);
    }

}
