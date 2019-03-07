package com.lambdaschool.lambdatable.services;

import com.lambdaschool.lambdatable.exception.ResourceNotFoundException;
import com.lambdaschool.lambdatable.model.Role;
import com.lambdaschool.lambdatable.model.RoleName;
import com.lambdaschool.lambdatable.model.User;
import com.lambdaschool.lambdatable.payload.ApiResponse;
import com.lambdaschool.lambdatable.payload.JwtAuthenticationResponse;
import com.lambdaschool.lambdatable.payload.LoginRequest;
import com.lambdaschool.lambdatable.payload.SignUpRequest;
import com.lambdaschool.lambdatable.repositories.RoleRepository;
import com.lambdaschool.lambdatable.repositories.UserRepository;
import com.lambdaschool.lambdatable.security.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider tokenProvider;

    public AuthService(AuthenticationManager authenticationManager,
                       UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder,
                       JwtTokenProvider tokenProvider) {

        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    public JwtAuthenticationResponse loginRequest(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserNameOrEmail(),
                        loginRequest.getPassword()
                ));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return new JwtAuthenticationResponse(jwt);
    }

    public ResponseEntity<?> registerUser(SignUpRequest signUpRequest) {

        if (userRepository.existsByUsername(signUpRequest.getUserName())) {
            return new ResponseEntity<>(new ApiResponse(false, "Username is already"), HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new ApiResponse(false, "Email is already taken"), HttpStatus.BAD_REQUEST);

        }

        if (userRepository.existsByGitHubName(signUpRequest.getGitHubName())) {
            return new ResponseEntity<>(new ApiResponse(false, "GitHub is already in used"), HttpStatus.BAD_REQUEST);
        }

        User user = createUser(signUpRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username")
                .buildAndExpand(user.getUsername()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true, "User Registered"));
    }


    private User createUser(SignUpRequest signUpRequest) {
        User user = new User(
                signUpRequest.getName(),
                signUpRequest.getUserName(),
                signUpRequest.getEmail(),
                signUpRequest.getPassword(),
                signUpRequest.getGitHubName());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new ResourceNotFoundException(""));

        user.setRoles(Collections.singleton(userRole));
        return userRepository.save(user);
    }
}
