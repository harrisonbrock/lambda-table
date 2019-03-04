package com.lambdaschool.lambdatable.services;

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
            return null;
        }
    }
}
