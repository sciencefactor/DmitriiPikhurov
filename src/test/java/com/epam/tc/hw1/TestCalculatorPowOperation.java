package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalculatorPowOperation {

    private final double precision = 0.000001;
    private Calculator calculator;

    @BeforeMethod
    void initCalculator() {
        calculator = new Calculator();
    }


    @DataProvider(name = "numbersToOperateDouble")
    static Object[][] numberToOperateDouble() {
        return new Object[][]{{1.2, 2, 1.44}, {0, 1.9, 0}, {1.9, 0, 1}, {9, 0.5, 3}, {-2, 3, -8}};
    }


    @Test(dataProvider = "numbersToOperateDouble")
    void powDoubleTest(double first, double second, double expectedResult) {
        Assertions.assertThat(expectedResult).isCloseTo(calculator.pow(first, second), Assertions.offset(precision));
    }


}
