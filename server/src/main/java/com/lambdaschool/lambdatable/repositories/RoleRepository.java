package com.lambdaschool.lambdatable.repositories;

import com.lambdaschool.lambdatable.model.Role;
import com.lambdaschool.lambdatable.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
