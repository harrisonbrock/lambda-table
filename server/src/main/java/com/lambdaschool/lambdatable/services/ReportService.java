package com.lambdaschool.lambdatable.services;

import com.lambdaschool.lambdatable.model.Report;
import com.lambdaschool.lambdatable.repositories.ReportRepository;
import com.lambdaschool.lambdatable.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final UserRepository userRepository;

    public ReportService(ReportRepository reportRepository, UserRepository userRepository) {
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
    }

    public Report createReport(Report report) {

        return  reportRepository.save(report);
    }
}
