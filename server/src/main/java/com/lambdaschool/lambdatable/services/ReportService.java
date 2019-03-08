package com.lambdaschool.lambdatable.services;

import com.lambdaschool.lambdatable.exception.ResourceNotFoundException;
import com.lambdaschool.lambdatable.model.Report;
import com.lambdaschool.lambdatable.model.User;
import com.lambdaschool.lambdatable.repositories.ReportRepository;
import com.lambdaschool.lambdatable.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final UserRepository userRepository;

    public ReportService(ReportRepository reportRepository, UserRepository userRepository) {
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
    }

    public Report createReport(Report report, User toFind) {


        return userRepository.findById(toFind.getId())
                .map(user -> {
                    report.setUser(user);
                    return reportRepository.save(report);
                })
                .orElseThrow(() -> new ResourceNotFoundException("User no found" ));
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public List<Report> getAllReportsByUser(User user) {

        return reportRepository.getByUser(user);
    }

    public Report deleteById(Long id) {
        Optional<Report> report = reportRepository.findById(id);
        if (report.isEmpty()) throw new ResourceNotFoundException("Report Id '" + id + "' not found");
        reportRepository.delete(report.get());
        return report.get();
    }

    public Report update(Long id, Report reportRequest) {
        Optional<Report> report = reportRepository.findById(id);

        if (report.isEmpty()) throw new ResourceNotFoundException("Report with '" + id + "' not found");
        else {
            reportRequest.setId(id);
            return reportRepository.save(reportRequest);
        }
    }
}
