package com.lambdaschool.lambdatable.controllers;

import com.lambdaschool.lambdatable.model.User;
import com.lambdaschool.lambdatable.services.MapValidationErrorService;
import com.lambdaschool.lambdatable.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;
    private final MapValidationErrorService errorService;

    public UserController(UserService userService, MapValidationErrorService errorService) {
        this.userService = userService;
        this.errorService = errorService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult result) {

        ResponseEntity<?> errorMap = errorService.mapValidationService(result);
        if(errorMap != null) return errorMap;

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

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/githubname/{gitHubName}")
    public ResponseEntity<?> updateUserGitHubName(
            @PathVariable String gitHubName,
            @Valid @RequestBody User userRequest,
            BindingResult result) {
        ResponseEntity<?> errorMap = errorService.mapValidationService(result);
        if(errorMap != null) return errorMap;

        User user = userService.updateUserByGitHubName(gitHubName, userRequest);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
