package com.company.calculator.services;

import com.company.calculator.exceptions.InvalidTermException;
import com.company.calculator.services.operations.ArithmeticCalculatorOperation;
import com.company.calculator.services.operations.ArithmeticCalculatorOperationFactory;
import com.company.calculator.services.operations.ArithmeticOperationType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class ArithmeticCalculatorServiceImpl implements ArithmeticCalculatorService {
    private final ArithmeticCalculatorOperationFactory arithmeticCalculatorOperationFactory;

    public ArithmeticCalculatorServiceImpl(final ArithmeticCalculatorOperationFactory arithmeticCalculatorOperationFactory) {
        this.arithmeticCalculatorOperationFactory = arithmeticCalculatorOperationFactory;
    }

    @Override
    public BigDecimal executeOperation(final BigDecimal firstTerm,
                                       final BigDecimal secondTerm,
                                       final ArithmeticOperationType arithmeticOperationType) {
        validateTerm(firstTerm, InvalidTermException.FIRST_TERM_IS_NULL);
        validateTerm(secondTerm, InvalidTermException.SECOND_TERM_IS_NULL);

        final ArithmeticCalculatorOperation arithmeticCalculatorAdditionOperation = arithmeticCalculatorOperationFactory.getStrategy(arithmeticOperationType);

        return arithmeticCalculatorAdditionOperation.execute(firstTerm, secondTerm);
    }

    private void validateTerm(final BigDecimal term,
                              final String messageIfError) {
        if (Objects.isNull(term)) {
            throw new InvalidTermException(messageIfError);
        }
    }
}
