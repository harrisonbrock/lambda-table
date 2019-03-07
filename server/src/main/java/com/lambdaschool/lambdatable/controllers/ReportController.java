package com.lambdaschool.lambdatable.controllers;

import com.lambdaschool.lambdatable.model.Report;
import com.lambdaschool.lambdatable.services.MapValidationErrorService;
import com.lambdaschool.lambdatable.services.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/reports", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {

    private final ReportService reportService;
    private final MapValidationErrorService errorService;

    public ReportController(ReportService reportService, MapValidationErrorService errorService) {
        this.reportService = reportService;
        this.errorService = errorService;
    }

    @PostMapping("/users/{gitHubUserName}")
    public ResponseEntity<?> createNewReport(
            @PathVariable String gitHubUserName,
            @Valid @RequestBody Report report,
            BindingResult result) {

        ResponseEntity<?> errorMap = errorService.mapValidationService(result);

        if (errorMap != null) return errorMap;
        Report newReport = reportService.createReport(report, gitHubUserName);
        return new ResponseEntity<>(newReport, HttpStatus.CREATED);
    }


}
