package com.lambdaschool.lambdatable.controllers;

import com.lambdaschool.lambdatable.model.User;
import com.lambdaschool.lambdatable.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/githubname/{gitHubName}")
    public ResponseEntity<?> getUserByGitHubName(@PathVariable String gitHubName) {
        User  user = userService.findUserByGitHubName(gitHubName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
