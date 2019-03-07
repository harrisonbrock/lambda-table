package com.lambdaschool.lambdatable.controllers;

import com.lambdaschool.lambdatable.services.MapValidationErrorService;
import com.lambdaschool.lambdatable.services.ReportService;
import com.lambdaschool.lambdatable.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserService userService;
    private final ReportService reportService;
    private final MapValidationErrorService errorService;

    public AdminController(UserService userService,
                           ReportService reportService,
                           MapValidationErrorService errorService) {

        this.userService = userService;
        this.reportService = reportService;
        this.errorService = errorService;
    }

    @GetMapping("/reports")
    public ResponseEntity<?> getAllReports() {
        return new ResponseEntity<>(reportService.getAllReports(), HttpStatus.OK);
    }

    @GetMapping("/reports/users/githubname/{gitHubName}")
    public ResponseEntity<?> getReportByGitHubName(@PathVariable String gitHubName) {
        return null;
    }
}
