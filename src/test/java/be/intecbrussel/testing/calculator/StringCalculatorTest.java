package be.intecbrussel.testing.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {


    //the tests have been written the implementation has not been written
    @Test
    void oneShouldReturnOne() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(1,calculator.add("1"));
    }
    @Test
    void emptyShouldReturnZero() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(0,calculator.add(""));
    }
    @Test
    void oneAndTwoShouldReturnThree() {
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(3,calculator.add("1,2"));
    }

}