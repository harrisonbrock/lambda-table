package com.lambdaschool.lambdatable.services;

import com.lambdaschool.lambdatable.model.Report;
import com.lambdaschool.lambdatable.repositories.ReportRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report createReport(Report report) {

        return  reportRepository.save(report);
    }
}
