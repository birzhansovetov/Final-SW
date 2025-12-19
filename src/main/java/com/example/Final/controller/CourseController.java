package com.example.Final.controller;

import com.example.Final.dto.CourseDto;
import com.example.Final.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
@Autowired
    private  CourseService courseService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody CourseDto dto) {
        courseService.saveCourse(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Long id,
                                          @RequestBody CourseDto dto) {
        courseService.update(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


