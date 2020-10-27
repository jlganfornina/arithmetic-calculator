package com.company.calculator.controllers;

import com.company.calculator.services.ArithmeticCalculatorService;
import com.company.calculator.services.operations.ArithmeticOperationType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public interface ArithmeticOperationsController {

    @GetMapping("/executeOperation")
    ResponseEntity<String> calculate(
            @RequestParam BigDecimal firstTerm,
            @RequestParam BigDecimal secondTerm,
            @RequestParam ArithmeticOperationType arithmeticOperationType);
}
