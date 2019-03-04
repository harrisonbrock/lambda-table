package com.lambdaschool.lambdatable.repositories;

import com.lambdaschool.lambdatable.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
