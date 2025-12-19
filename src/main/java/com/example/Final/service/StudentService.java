package com.example.Final.service;

import com.example.Final.dto.StudentDto;
import com.example.Final.entity.Student;
import com.example.Final.mapper.StudentMapper;
import com.example.Final.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    public List<StudentDto> findAll() {
        List<Student> students = studentRepository.findAll();
        return studentMapper.toDtoList(students);
    }

    public StudentDto findById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return studentMapper.toDto(student);
    }

    public StudentDto saveStudent(StudentDto dto) {
        Student entity = studentMapper.toEntity(dto);
        Student saved = studentRepository.save(entity);
        return studentMapper.toDto(saved);
    }

    public StudentDto updateStudent(Long id, StudentDto dto) {
        Student student = studentRepository.findById(id).orElse(null);

        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());

        return studentMapper.toDto(studentRepository.save(student));
    }


    public boolean deleteById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if(Objects.isNull(student)){
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }
}

