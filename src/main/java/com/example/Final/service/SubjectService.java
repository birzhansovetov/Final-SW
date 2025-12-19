package com.example.Final.service;

import com.example.Final.dto.SubjectDto;
import com.example.Final.entity.Student;
import com.example.Final.entity.Subject;
import com.example.Final.mapper.SubjectMapper;
import com.example.Final.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    public SubjectService(SubjectRepository subjectRepository,
                          SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }

    public List<SubjectDto> findAll() {
        return subjectMapper.toDtoList(subjectRepository.findAll());
    }

    public SubjectDto findById(Long id) {
        Subject subject = subjectRepository.findById(id).orElse(null);
        return subjectMapper.toDto(subject);
    }

    public SubjectDto saveSubject(SubjectDto dto) {
        Subject saved = subjectRepository.save(subjectMapper.toEntity(dto));
        return subjectMapper.toDto(saved);
    }
    public SubjectDto update(Long id, SubjectDto dto) {
        Subject subject = subjectRepository.findById(id).orElse(null);

        subject.setName(dto.getName());

        Subject saved = subjectRepository.save(subject);
        return subjectMapper.toDto(saved);
    }


    public boolean deleteById(Long id) {
        Subject subject= subjectRepository.findById(id).orElse(null);
        if(Objects.isNull(subject)){
            return false;
        }
        subjectRepository.deleteById(id);
        return true;
    }
}
