package com.lambdaschool.lambdatable.controllers;

import com.lambdaschool.lambdatable.model.Report;
import com.lambdaschool.lambdatable.services.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/reports", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {

//    private final ReportService reportService;

}
