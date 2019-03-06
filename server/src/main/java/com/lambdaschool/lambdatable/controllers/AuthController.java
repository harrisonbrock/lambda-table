package com.lambdaschool.lambdatable.controllers;

import com.lambdaschool.lambdatable.payload.LoginRequest;
import com.lambdaschool.lambdatable.payload.SignUpRequest;
import com.lambdaschool.lambdatable.services.AuthService;
import com.lambdaschool.lambdatable.services.MapValidationErrorService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final MapValidationErrorService errorService;

    public AuthController(AuthService authService, MapValidationErrorService errorService) {
        this.authService = authService;
        this.errorService = errorService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {

        ResponseEntity<?> errors = errorService.mapValidationService(result);
        if (errors != null) return errors;

        return ResponseEntity.ok(authService.loginRequest(loginRequest));

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest,BindingResult result) {

        ResponseEntity<?> error = errorService.mapValidationService(result);
        if (error != null) return error;

        return authService.registerUser(signUpRequest);
    }
}
