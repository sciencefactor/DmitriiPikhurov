package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalculatorMultOperation {

    private final double precision = 0.000001;
    private Calculator calculator;

    @BeforeMethod
    void initCalculator() {
        calculator = new Calculator();
    }

    @DataProvider(name = "numbersToOperateLong")
    static Object[][] numberToOperateLong() {
        return new Object[][]{{252L, 748L, 188496L}, {0L, 111L, 0L}, {-25L, 100L, -2500L}};
    }

    @DataProvider(name = "numbersToOperateDouble")
    static Object[][] numberToOperateDouble() {
        return new Object[][]{{1.5, 1.28, 1.92}, {0, 1.9, 0}, {-1.8, 1.2, -2.16}};
    }

    @Test(dataProvider = "numbersToOperateLong")
    void multLongTest(long first, long second, long expectedResult) {
        Assertions.assertThat(expectedResult).isEqualTo(calculator.mult(first, second));
    }

    @Test(dataProvider = "numbersToOperateDouble")
    void multDoubleTest(double first, double second, double expectedResult) {
        Assertions.assertThat(expectedResult).isCloseTo(calculator.mult(first, second), Assertions.offset(precision));
    }

}
