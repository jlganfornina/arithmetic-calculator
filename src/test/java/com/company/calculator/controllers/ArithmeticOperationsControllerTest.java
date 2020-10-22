package com.company.calculator.controllers;

import com.company.calculator.services.ArithmeticCalculatorService;
import com.company.calculator.services.operations.ArithmeticOperationType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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

@WebMvcTest(ArithmeticOperationsController.class)
class ArithmeticOperationsControllerTest {
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
}
