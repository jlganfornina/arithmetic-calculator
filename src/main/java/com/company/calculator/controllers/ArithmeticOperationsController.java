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
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"Arithmetic operations services"})
public class ArithmeticOperationsController {
    private final ArithmeticCalculatorService arithmeticCalculatorService;

    public ArithmeticOperationsController(final ArithmeticCalculatorService arithmeticCalculatorService) {
        this.arithmeticCalculatorService = arithmeticCalculatorService;
    }

    @GetMapping("/executeOperation")
    @ApiOperation(value = "Execute an arithmetic operation")
    public ResponseEntity<String> calculate(
            @ApiParam(value = "First term for the operation", required = true, example = "34434.43434")
            @RequestParam BigDecimal firstTerm,
            @ApiParam(value = "Second term for the operation", required = true, example = "756.54")
            @RequestParam BigDecimal secondTerm,
            @ApiParam(value = "Operation", required = true, example = "ADDITION")
            @RequestParam ArithmeticOperationType arithmeticOperationType) {
        final BigDecimal result = arithmeticCalculatorService.executeOperation(firstTerm,
                secondTerm,
                arithmeticOperationType);
        return ResponseEntity.ok(result.toString());
    }
}
