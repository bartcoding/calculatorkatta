package be.intecbrussel.testing.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

    private int count =0;

    public int add(String numbers){
        count++;
        if (numbers.equals("")) {
            return 0;
        }
        int[] numberArray =convertStringOfNumbersToIntArray(numbers);
        checkForNegatives(numberArray);
        return IntStream.of(numberArray)
                .sum();
    }
    public int getCalledCount(){
        return count;
    }

    private void checkForNegatives(int[] numberArray) {
        List<Integer> negativeNumbers = new ArrayList<>();
        for (int number :numberArray){
            if (number<0){
                negativeNumbers.add(number);
            }
        }
        if (negativeNumbers.size()>0){
            String negativeNumbersAsStringWithCommas = negativeNumbers.stream()
                                                                        .map(Objects::toString)
                                                                        .collect(Collectors.joining(","));
            throw new RuntimeException("negatives not allowed : " + negativeNumbersAsStringWithCommas);
        }
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
