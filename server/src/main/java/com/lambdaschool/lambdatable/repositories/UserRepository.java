package com.lambdaschool.lambdatable.repositories;

import com.lambdaschool.lambdatable.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByGitHubName(String gitHubName);
    Optional<User> findByName(String name);
    Optional<User> findByUsernameOrEmail(String userName, String email);
    boolean existsByUsername(String userName);
    boolean existsByEmail(String email);
    boolean existsByGitHubName(String gitHubName);

}
