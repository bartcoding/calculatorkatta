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
    @Test
    void useNewLineAsSeperatorBetweenNumbers(){
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(6,calculator.add("1\n2,3"));
    }
    @Test
    void useDifferentDelimiters(){
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(3,calculator.add("//;\n1;2"));
    }
    @Test
    void negativeNumberThrowsException(){
        StringCalculator calculator = new StringCalculator();
        Exception exception = Assertions.assertThrows(RuntimeException.class,()->calculator.add("1,2,-3"));
        Assertions.assertEquals("negatives not allowed : -3",exception.getMessage());
    }
    @Test
    void multipleNegativeNumbersThrowsException(){
        StringCalculator calculator = new StringCalculator();
        Exception exception = Assertions.assertThrows(RuntimeException.class,()->calculator.add("1,-2,-3"));
        Assertions.assertEquals("negatives not allowed : -2,-3",exception.getMessage());
    }
    @Test
    void getCalledCount0TimesCalled(){
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(0,calculator.getCalledCount());
    }
    @Test
    void getCalledCount2TimesCalled(){
        StringCalculator calculator = new StringCalculator();
        calculator.add("");
        calculator.add("");
        Assertions.assertEquals(2,calculator.getCalledCount());
    }
    @Test
    void getCalledCount10TimesCalled(){
        StringCalculator calculator = new StringCalculator();
        calculator.add("");
        calculator.add("");
        calculator.add("");
        calculator.add("");
        calculator.add("");
        calculator.add("");
        calculator.add("");
        calculator.add("");
        calculator.add("");
        calculator.add("");
        Assertions.assertEquals(10,calculator.getCalledCount());
    }
    @Test
    void ignoreNumbersOver1000(){
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(2,calculator.add("2,1000"));
    }
    @Test
    void multicharacterDelimiters(){
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(6,calculator.add("//[***]\n1***2***3"));
    }
    @Test
    void multipleDelimiters(){
        StringCalculator calculator = new StringCalculator();
        Assertions.assertEquals(6,calculator.add("//[*][%]\n1*2%3"));
    }

}