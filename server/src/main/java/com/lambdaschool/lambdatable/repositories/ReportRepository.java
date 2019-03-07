package com.lambdaschool.lambdatable.repositories;

import com.lambdaschool.lambdatable.model.Report;
import com.lambdaschool.lambdatable.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
//    List<Report> getByUserName(String userName);
    List<Report> getByUser(User user);
}
