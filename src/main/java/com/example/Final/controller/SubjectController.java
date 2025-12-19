package com.example.Final.controller;

import com.example.Final.dto.SubjectDto;
import com.example.Final.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
@Autowired
    private    SubjectService subjectService;


    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(subjectService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(subjectService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addSubject(@RequestBody SubjectDto dto) {
        subjectService.saveSubject(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubject(@PathVariable Long id,
                                           @RequestBody SubjectDto dto) {
        subjectService.update(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable Long id) {
        subjectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
