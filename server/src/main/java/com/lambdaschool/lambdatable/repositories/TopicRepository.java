package com.lambdaschool.lambdatable.repositories;

import com.lambdaschool.lambdatable.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
