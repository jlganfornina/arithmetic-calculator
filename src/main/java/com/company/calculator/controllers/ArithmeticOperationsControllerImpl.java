package com.company.calculator.controllers;

import com.company.calculator.operations.strategy.ArithmeticOperationType;
import com.company.calculator.services.ArithmeticCalculatorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Api(tags = {"Arithmetic operations services"})
public class ArithmeticOperationsControllerImpl implements ArithmeticOperationsController {
    private final ArithmeticCalculatorService arithmeticCalculatorService;

    public ArithmeticOperationsControllerImpl(final ArithmeticCalculatorService arithmeticCalculatorService) {
        this.arithmeticCalculatorService = arithmeticCalculatorService;
    }

    @Override
    @ApiOperation(value = "Execute an arithmetic operation")
    public ResponseEntity<String> calculate(
            @ApiParam(value = "First term for the operation", required = true, example = "34434.43434")
            BigDecimal firstTerm,
            @ApiParam(value = "Second term for the operation", required = true, example = "756.54")
            BigDecimal secondTerm,
            @ApiParam(value = "Operation", required = true, example = "ADDITION")
            ArithmeticOperationType arithmeticOperationType) {
        final BigDecimal result = arithmeticCalculatorService.executeOperation(firstTerm,
                secondTerm,
                arithmeticOperationType);
        return ResponseEntity.ok(result.toString());
    }
}
