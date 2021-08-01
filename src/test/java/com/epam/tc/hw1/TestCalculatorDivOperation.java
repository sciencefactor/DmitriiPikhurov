package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalculatorDivOperation {

    private final double precision = 0.000001;
    private Calculator calculator;

    @BeforeMethod
    void initCalculator() {
        calculator = new Calculator();
    }

    @DataProvider(name = "numbersToOperateLong")
    static Object[][] numberToOperateLong() {
        return new Object[][]{{875L, 3L, 291L}, {3L, 875L, 0L}, {-25L, 3L, -8L}, {5, 0, 0}};
    }

    @DataProvider(name = "numbersToOperateDouble")
    static Object[][] numbersToOperateDouble() {
        return new Object[][]{{1.5, 1.28, 1.171875}, {0, 1.9, 0}, {-1.8, 1.2, -1.5}, {1.5, 0, 0}};
    }

    @Test(dataProvider = "numbersToOperateLong")
    void divLongTest(long first, long second, long expectedResult) {
        if (second == 0L) {
            Assertions.assertThatThrownBy(() -> calculator.div(first, second))
                    .isInstanceOf(NumberFormatException.class);
        } else {
            Assertions.assertThat(expectedResult).isEqualTo(calculator.div(first, second));
        }

    }

    @Test(dataProvider = "numbersToOperateDouble")
    void divDoubleTest(double first, double second, double expectedResult) {
        if (second == 0) {
            Assertions.assertThatThrownBy(() -> calculator.div(first, second))
                    .isInstanceOf(NumberFormatException.class);
        } else {
            Assertions.assertThat(expectedResult)
                    .isCloseTo(calculator.div(first, second), Assertions.offset(precision));
        }
    }

}
