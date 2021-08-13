package com.epam.tc.hw1;


import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalculatorSumOperation {

    private final double precision = 0.000001;
    private Calculator calculator;

    @BeforeMethod
    void initCalculator() {
        calculator = new Calculator();
    }

    @DataProvider(name = "numbersToOperateLong")
    static Object[][] numberToOperateLong() {
        return new Object[][]{{252L, 748L, 1000L}, {0L, 111L, 111L}, {-25L, 100L, 75L}};
    }

    @DataProvider(name = "numbersToOperateDouble")
    static Object[][] numbersToOperateDouble() {
        return new Object[][]{{1.5, 1.28, 2.78}, {0, 1.9, 1.9}, {-1.8, 1.2, -0.6}};
    }

    @Test(dataProvider = "numbersToOperateLong")
    void sumLongTest(long first, long second, long expectedResult) {
        Assertions.assertThat(calculator.sum(first, second)).isEqualTo(expectedResult);
    }

    @Test(dataProvider = "numbersToOperateDouble")
    void sumDoubleTest(double first, double second, double expectedResult) {
        Assertions.assertThat(calculator.sum(first, second)).isCloseTo(expectedResult, Assertions.offset(precision));
    }


}
