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
        StringBuilder delimiterCharacters = new StringBuilder("[,\n]");
        if(stringOfNumbers.startsWith("//")){
            delimiterCharacters = delimiterCharacters.insert(1,stringOfNumbers.charAt(2));
            stringOfNumbers = stringOfNumbers.substring(4);
        }

        return stringOfNumbers.split(delimiterCharacters.toString());
    }

    private int[] convertStringOfNumberArrayToIntArray(String[] stringOfNumbers) {
        return Stream.of(stringOfNumbers).mapToInt(Integer::parseInt)
                .toArray();
    }


}
