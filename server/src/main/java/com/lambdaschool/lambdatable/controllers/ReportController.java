package com.lambdaschool.lambdatable.controllers;

import com.lambdaschool.lambdatable.model.Report;
import com.lambdaschool.lambdatable.model.User;
import com.lambdaschool.lambdatable.repositories.UserRepository;
import com.lambdaschool.lambdatable.security.CurrentUser;
import com.lambdaschool.lambdatable.security.UserPrincipal;
import com.lambdaschool.lambdatable.services.MapValidationErrorService;
import com.lambdaschool.lambdatable.services.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/reports", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {

    private final ReportService reportService;
    private final MapValidationErrorService errorService;
    private final UserRepository userRepository;

    public ReportController(ReportService reportService, MapValidationErrorService errorService, UserRepository userRepository) {
        this.reportService = reportService;
        this.errorService = errorService;
        this.userRepository = userRepository;
    }

    @PostMapping()
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createNewReport(
            @CurrentUser UserPrincipal currentUser,
            @Valid @RequestBody Report report,
            BindingResult result) {

        ResponseEntity<?> errorMap = errorService.mapValidationService(result);

        if (errorMap != null) return errorMap;
        User user = userRepository.findById(currentUser.getId()).get();

        Report newReport = reportService.createReport(report, user);
        return new ResponseEntity<>(newReport, HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getReport(@CurrentUser UserPrincipal currentUser) {
        User user = userRepository.findById(currentUser.getId()).get();
        System.out.println(user.getId() + " name" + user.getName());
        List<Report> reports = reportService.getAllReportsByUser(user);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteReport(@PathVariable Long id) {
        return new ResponseEntity<>(reportService.deleteById(id), HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> updateReport(@RequestBody Report reportRequest) {
        return new ResponseEntity<>(reportService.update(reportRequest), HttpStatus.OK);
    }


}
