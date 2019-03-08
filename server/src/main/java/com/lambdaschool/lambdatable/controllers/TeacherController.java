package com.lambdaschool.lambdatable.controllers;

import com.lambdaschool.lambdatable.repositories.TeacherRopistory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api/teachers")
public class TeacherController {

    private final TeacherRopistory teacherRopistory;

    public TeacherController(TeacherRopistory teacherRopistory) {
        this.teacherRopistory = teacherRopistory;
    }

    @GetMapping
    public ResponseEntity<?> getAllTeachers() {
        return new ResponseEntity<>(teacherRopistory.findAll(), HttpStatus.OK);
    }
}
