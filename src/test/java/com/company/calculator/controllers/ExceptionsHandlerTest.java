package com.company.calculator.controllers;

import com.company.calculator.exceptions.InvalidTermException;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class ExceptionsHandlerTest {

    @Test
    void shouldCallTracerWhenInvalidTermException() {
        // given
        final TracerImpl tracer = spy(new TracerImpl());
        final ExceptionsHandler exceptionsHandler = new ExceptionsHandler(tracer);

        final String message = "Message";
        final InvalidTermException invalidTermException = new InvalidTermException(message);

        final String expectedMessage = MessageFormat.format(ExceptionsHandler.TRACER_MESSAGE, message);

        // when
        exceptionsHandler.handleApiException(invalidTermException);

        // then

        verify(tracer, only()).trace(expectedMessage);
    }
}
