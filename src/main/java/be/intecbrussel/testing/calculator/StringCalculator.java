package be.intecbrussel.testing.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.equals("")) {
            return 0;
        }
        return IntStream.of(convertStringOfNumbersToIntArray(numbers)).sum();
    }

    private int[] convertStringOfNumbersToIntArray(String stringOfNumbers) {
        String[] stringArrayOfNumbers = extractNumbersFromString(stringOfNumbers);
        return convertStringOfNumberArrayToIntArray(stringArrayOfNumbers);
    }

    private String[] extractNumbersFromString(String stringOfNumbers) {
        return stringOfNumbers.split("[,\n]");
    }

    private int[] convertStringOfNumberArrayToIntArray(String[] stringOfNumbers) {
        return Stream.of(stringOfNumbers).mapToInt(Integer::parseInt)
                .toArray();
    }


}
