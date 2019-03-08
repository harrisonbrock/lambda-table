package com.lambdaschool.lambdatable.repositories;

import com.lambdaschool.lambdatable.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
