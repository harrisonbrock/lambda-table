package com.lambdaschool.lambdatable.controllers;

import com.lambdaschool.lambdatable.repositories.ProjectManagerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/pm")
public class ProjectManagerController {

    private final ProjectManagerRepository projectManagerRepository;

    public ProjectManagerController(ProjectManagerRepository projectManagerRepository) {
        this.projectManagerRepository = projectManagerRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllProjectManagers() {
        return new ResponseEntity<>(projectManagerRepository.findAll(), HttpStatus.OK);
    }
}
