package com.lambdaschool.lambdatable.repositories;

import com.lambdaschool.lambdatable.model.ProjectManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectManagerRepository extends JpaRepository<ProjectManager, Long> {
}
