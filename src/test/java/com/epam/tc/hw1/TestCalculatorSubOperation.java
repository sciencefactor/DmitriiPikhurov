package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalculatorSubOperation {

    private final double precision = 0.000001;

    private Calculator calculator;

    @BeforeMethod
    void initCalculator() {
        calculator = new Calculator();
    }

    @DataProvider(name = "numbersToOperateLong")
    static Object[][] numberToOperateLong() {
        return new Object[][]{{252L, 748L, -496L}, {0L, 111L, -111L}, {-25L, 100L, -125L}};
    }

    @DataProvider(name = "numbersToOperateDouble")
    static Object[][] numbersToOperateDouble() {
        return new Object[][]{{1.5, 1.28, 0.22}, {0, 1.9, -1.9}, {-1.8, 1.2, -3}};
    }

    @Test(dataProvider = "numbersToOperateLong")
    void subLongTest(long first, long second, long expectedResult) {
        Assertions.assertThat(calculator.sub(first, second)).isEqualTo(expectedResult);
    }

    @Test(dataProvider = "numbersToOperateDouble")
    void subDoubleTest(double first, double second, double expectedResult) {
        Assertions.assertThat(calculator.sub(first, second)).isCloseTo(expectedResult, Assertions.offset(precision));
    }


}
