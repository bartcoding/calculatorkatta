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
        String delimiterCharacters = "[,\n]";
        if (stringOfNumbers.startsWith("//")) {
            delimiterCharacters = getDelimiterCharachters(stringOfNumbers);
            stringOfNumbers = stringOfNumbers.substring(4);
        }
        return stringOfNumbers.split(delimiterCharacters.toString());
    }

    private String getDelimiterCharachters(String stringOfNumbers) {
        return "["+stringOfNumbers.charAt(2)+",\n]";
    }


    private int[] convertStringOfNumberArrayToIntArray(String[] stringOfNumbers) {
        return Stream.of(stringOfNumbers).mapToInt(Integer::parseInt)
                .toArray();
    }


}
