package be.intecbrussel.testing.calculator;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

    public int add(String numbers){
        if(numbers.equals("")){
            return 0;
        }
        return IntStream.of(convertStringOfNumbersToIntArray(numbers)).sum();
    }

    private int[] convertStringOfNumbersToIntArray(String stringOfNumbers){
        String[] stringArrayOfNumbers = stringOfNumbers.split(",");
        return convertStringOfNumberArrayToIntArray(stringArrayOfNumbers);
    }

    private int[] convertStringOfNumberArrayToIntArray(String[] stringOfNumbers) {
        return Stream.of(stringOfNumbers).mapToInt(Integer::parseInt)
                                         .toArray();
    }


}
