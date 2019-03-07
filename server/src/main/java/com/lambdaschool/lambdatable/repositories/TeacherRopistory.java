package com.lambdaschool.lambdatable.repositories;

import com.lambdaschool.lambdatable.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRopistory extends JpaRepository<Teacher, Long> {
}
