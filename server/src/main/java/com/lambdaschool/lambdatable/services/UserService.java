package com.lambdaschool.lambdatable.services;

import com.lambdaschool.lambdatable.exception.ResourceNotFoundException;
import com.lambdaschool.lambdatable.model.User;
import com.lambdaschool.lambdatable.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserByGitHubName(String gitHubName) {
        Optional<User> user = userRepository.findByGitHubUserName(gitHubName.toLowerCase());

        if (user.isPresent()) {
            return user.get();
        }
        else {
            throw new ResourceNotFoundException("GitHub Name '" + gitHubName + "' not found");
        }
    }

    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        }
        else {
            throw new ResourceNotFoundException("User Id '" + id + "' not found");
        }
    }
}
