package com.example.Final.ServiceTest;

import com.example.Final.dto.SubjectDto;
import com.example.Final.service.SubjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class SubjectServiceTest {
    @Autowired
    private SubjectService subjectService;

    @Test
    void getAllTest(){
        List<SubjectDto> subjectDtos = subjectService.findAll();
        Assertions.assertNotNull(subjectDtos);
        Assertions.assertNotEquals(0,subjectDtos.size());
        for (int i = 0;i<subjectDtos.size();i++){
            SubjectDto subjectDto= subjectDtos.get(i);
            Assertions.assertNotNull(subjectDto.getId());
            Assertions.assertNotNull(subjectDto.getName());
        }
    }
    @Test
    void getByIdTest(){
        Random random = new Random();
        int RandomIndex = random.nextInt(subjectService.findAll().size());
        Long someId = subjectService.findAll().get(RandomIndex).getId();

        SubjectDto subjectDto = subjectService.findById(someId);

        Assertions.assertNotNull(subjectDto);
        Assertions.assertNotNull(subjectDto.getId());
        Assertions.assertNotNull(subjectDto.getName());

        SubjectDto check = subjectService.findById(-1L);
        Assertions.assertNull(check);
    }

    @Test
    void saveSubjectTest(){
        SubjectDto subjectDto  = new SubjectDto();
        subjectDto.setName("tech");


        SubjectDto createdSubject= subjectService.saveSubject(subjectDto);
        Assertions.assertNotNull(createdSubject);
        Assertions.assertNotNull(createdSubject.getId());
        Assertions.assertNotNull(createdSubject.getName());

        Assertions.assertEquals(subjectDto.getName(),createdSubject.getName());
        SubjectDto getSubject = subjectService.findById(createdSubject.getId());

        Assertions.assertNotNull(getSubject);
        Assertions.assertNotNull(getSubject.getId());
        Assertions.assertNotNull(getSubject.getName());
        Assertions.assertEquals(createdSubject.getId(),getSubject.getId());
        Assertions.assertEquals(createdSubject.getName(),getSubject.getName());

    }
    @Test
    void updateTest(){
        Random random = new Random();
        int RandomIndex = random.nextInt(subjectService.findAll().size());
        Long someId = subjectService.findAll().get(RandomIndex).getId();

        SubjectDto subjectDto  = new SubjectDto();
        subjectDto.setName("tech");


        SubjectDto beforeUpdate = subjectService.update(someId,subjectDto);
        Assertions.assertNotNull(beforeUpdate);
        Assertions.assertNotNull(beforeUpdate.getId());
        Assertions.assertNotNull(beforeUpdate.getName());

        Assertions.assertEquals(subjectDto.getName(),beforeUpdate.getName());

        SubjectDto afterUpdate = subjectService.findById(someId);
        Assertions.assertNotNull(afterUpdate);
        Assertions.assertNotNull(afterUpdate.getId());
        Assertions.assertNotNull(afterUpdate.getName());

        Assertions.assertEquals(beforeUpdate.getId(),afterUpdate.getId());
        Assertions.assertEquals(beforeUpdate.getName(),afterUpdate.getName());

    }
    @Test
    void deleteCategoryTest(){
        SubjectDto created = subjectService.saveSubject(new SubjectDto(null, "temp-subject"));

        Long id = created.getId();
        Assertions.assertNotNull(id);

        Assertions.assertTrue(subjectService.deleteById(id));

        Assertions.assertNull(subjectService.findById(id));
    }

}
