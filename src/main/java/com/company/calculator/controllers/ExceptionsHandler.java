package com.company.calculator.controllers;

import com.company.calculator.exceptions.InvalidTermException;
import io.corp.calculator.TracerImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.MessageFormat;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {
    static final String TRACER_MESSAGE = "Operation error due to: {0}";

    private final TracerImpl tracer;

    public ExceptionsHandler(final TracerImpl tracer) {
        this.tracer = tracer;
    }

    @ExceptionHandler({InvalidTermException.class})
    public ResponseEntity<String> handleApiException(final InvalidTermException e) {
        traceException(e);
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    private void traceException(final RuntimeException runtimeException) {
        final String message = MessageFormat.format(TRACER_MESSAGE, runtimeException.getMessage());
        tracer.trace(message);
    }
}
