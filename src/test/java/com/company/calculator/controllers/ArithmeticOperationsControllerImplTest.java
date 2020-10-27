package com.company.calculator.controllers;

import com.company.calculator.configurations.TracerConfiguration;
import com.company.calculator.exceptions.InvalidOperationTypeException;
import com.company.calculator.exceptions.InvalidTermException;
import com.company.calculator.services.ArithmeticCalculatorService;
import com.company.calculator.operations.strategy.ArithmeticOperationType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArithmeticOperationsControllerImpl.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = {ExceptionsHandler.class, TracerConfiguration.class, ArithmeticOperationsControllerImpl.class})
class ArithmeticOperationsControllerImplTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArithmeticCalculatorService arithmeticCalculatorService;

    @Test
    void shouldExecuteAdditionOperation() throws Exception {
        // given
        final BigDecimal firstTerm = BigDecimal.valueOf(Math.random());
        final BigDecimal secondTerm = BigDecimal.valueOf(Math.random());
        final ArithmeticOperationType arithmeticOperationType = ArithmeticOperationType.ADDITION;
        final BigDecimal expectedResult = firstTerm.add(secondTerm);
        when(arithmeticCalculatorService.executeOperation(firstTerm, secondTerm, arithmeticOperationType)).thenReturn(expectedResult);

        // when
        final ResultMatcher resultMatcher = status().isOk();
        final MockHttpServletRequestBuilder additionRequest = MockMvcRequestBuilders.get("/api/executeOperation")
                .param("firstTerm", firstTerm.toString())
                .param("secondTerm", secondTerm.toString())
                .param("arithmeticOperationType", arithmeticOperationType.toString())
                .accept(MediaType.APPLICATION_JSON);

        final String result = mockMvc.perform(additionRequest)
                .andExpect(resultMatcher)
                .andReturn()
                .getResponse()
                .getContentAsString();

        // then
        assertThat(result).isEqualTo(expectedResult.toString());
        verify(arithmeticCalculatorService, only()).executeOperation(firstTerm, secondTerm, arithmeticOperationType);
    }

    @Test
    void shouldExecuteSubtractOperation() throws Exception {
        // given
        final BigDecimal firstTerm = BigDecimal.valueOf(Math.random());
        final BigDecimal secondTerm = BigDecimal.valueOf(Math.random());
        final ArithmeticOperationType arithmeticOperationType = ArithmeticOperationType.SUBTRACT;
        final BigDecimal expectedResult = firstTerm.add(secondTerm);
        when(arithmeticCalculatorService.executeOperation(firstTerm, secondTerm, arithmeticOperationType)).thenReturn(expectedResult);

        // when
        final ResultMatcher resultMatcher = status().isOk();
        final MockHttpServletRequestBuilder additionRequest = MockMvcRequestBuilders.get("/api/executeOperation")
                .param("firstTerm", firstTerm.toString())
                .param("secondTerm", secondTerm.toString())
                .param("arithmeticOperationType", arithmeticOperationType.toString())
                .accept(MediaType.APPLICATION_JSON);

        final String result = mockMvc.perform(additionRequest)
                .andExpect(resultMatcher)
                .andReturn()
                .getResponse()
                .getContentAsString();

        // then
        assertThat(result).isEqualTo(expectedResult.toString());
        verify(arithmeticCalculatorService, only()).executeOperation(firstTerm, secondTerm, arithmeticOperationType);
    }

    @Test
    void shouldGetBadRequestWhenFirstTermIsNotANumber() throws Exception {
        // given
        final String firstTerm = "NO_NUMBER";
        final BigDecimal secondTerm = BigDecimal.valueOf(Math.random());
        final ArithmeticOperationType arithmeticOperationType = ArithmeticOperationType.ADDITION;

        // when
        final ResultMatcher resultMatcher = status().isBadRequest();
        final MockHttpServletRequestBuilder additionRequest = MockMvcRequestBuilders.get("/api/executeOperation")
                .param("firstTerm", firstTerm)
                .param("secondTerm", secondTerm.toString())
                .param("arithmeticOperationType", arithmeticOperationType.toString())
                .accept(MediaType.APPLICATION_JSON);

        // then
        mockMvc.perform(additionRequest)
                .andExpect(resultMatcher);
    }

    @Test
    void shouldGetBadRequestWhenSecondTermIsNotANumber() throws Exception {
        // given
        final BigDecimal firstTerm = BigDecimal.valueOf(Math.random());
        final String secondTerm = "NO_NUMBER";
        final ArithmeticOperationType arithmeticOperationType = ArithmeticOperationType.ADDITION;

        // when
        final ResultMatcher resultMatcher = status().isBadRequest();
        final MockHttpServletRequestBuilder additionRequest = MockMvcRequestBuilders.get("/api/executeOperation")
                .param("firstTerm", firstTerm.toString())
                .param("secondTerm", secondTerm)
                .param("arithmeticOperationType", arithmeticOperationType.toString())
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(additionRequest)
                .andExpect(resultMatcher);
    }

    @Test
    void shouldGetBadRequestOnEmptyFirstTerm() throws Exception {
        // given
        final BigDecimal secondTerm = BigDecimal.valueOf(Math.random());
        final ArithmeticOperationType arithmeticOperationType = ArithmeticOperationType.ADDITION;
        when(arithmeticCalculatorService.executeOperation(null, secondTerm, arithmeticOperationType))
                .thenThrow(new InvalidTermException(InvalidTermException.FIRST_TERM_IS_NULL));

        // when
        final ResultMatcher resultMatcher = status().isBadRequest();
        final MockHttpServletRequestBuilder additionRequest = MockMvcRequestBuilders.get("/api/executeOperation")
                .param("firstTerm", "")
                .param("secondTerm", secondTerm.toString())
                .param("arithmeticOperationType", arithmeticOperationType.toString())
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(additionRequest)
                .andExpect(resultMatcher);
    }

    @Test
    void shouldGetBadRequestOnEmptySecondTerm() throws Exception {
        // given
        final BigDecimal firstTerm = BigDecimal.valueOf(Math.random());
        final ArithmeticOperationType arithmeticOperationType = ArithmeticOperationType.ADDITION;
        when(arithmeticCalculatorService.executeOperation(firstTerm, null, arithmeticOperationType))
                .thenThrow(new InvalidTermException(InvalidTermException.SECOND_TERM_IS_NULL));

        // when
        final ResultMatcher resultMatcher = status().isBadRequest();
        final MockHttpServletRequestBuilder additionRequest = MockMvcRequestBuilders.get("/api/executeOperation")
                .param("firstTerm", firstTerm.toString())
                .param("secondTerm", "")
                .param("arithmeticOperationType", arithmeticOperationType.toString())
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(additionRequest)
                .andExpect(resultMatcher);
    }

    @Test
    void shouldGetBadRequestOnInvalidArithmeticOperationType() throws Exception {
        // given
        final BigDecimal firstTerm = BigDecimal.valueOf(Math.random());
        final BigDecimal secondTerm = BigDecimal.valueOf(Math.random());
        final String invalidOperation = "INVALID_OPERATION";

        // when
        final ResultMatcher resultMatcher = status().isBadRequest();
        final MockHttpServletRequestBuilder additionRequest = MockMvcRequestBuilders.get("/api/executeOperation")
                .param("firstTerm", firstTerm.toString())
                .param("secondTerm", secondTerm.toString())
                .param("arithmeticOperationType", invalidOperation)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(additionRequest)
                .andExpect(resultMatcher);
    }

    @Test
    void shouldGetBadRequestOnEmptyArithmeticOperationType() throws Exception {
        // given
        final BigDecimal firstTerm = BigDecimal.valueOf(Math.random());
        final BigDecimal secondTerm = BigDecimal.valueOf(Math.random());
        when(arithmeticCalculatorService.executeOperation(firstTerm, secondTerm, null))
                .thenThrow(new InvalidOperationTypeException());

        // when
        final ResultMatcher resultMatcher = status().isBadRequest();
        final MockHttpServletRequestBuilder additionRequest = MockMvcRequestBuilders.get("/api/executeOperation")
                .param("firstTerm", firstTerm.toString())
                .param("secondTerm", secondTerm.toString())
                .param("arithmeticOperationType", "")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(additionRequest)
                .andExpect(resultMatcher);
    }
}
