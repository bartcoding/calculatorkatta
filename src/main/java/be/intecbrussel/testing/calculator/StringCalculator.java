package be.intecbrussel.testing.calculator;

import java.util.ArrayList;
import java.util.List;
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
        List<String> numberAsStringList = new ArrayList<>();
        for (String s: stringArrayOfNumbers){
            for(String number :s.split("\n")){
                numberAsStringList.add(number);
            }
        }
        stringArrayOfNumbers = numberAsStringList.toArray(new String[numberAsStringList.size()]);
        return convertStringOfNumberArrayToIntArray(stringArrayOfNumbers);
    }

    private int[] convertStringOfNumberArrayToIntArray(String[] stringOfNumbers) {
        return Stream.of(stringOfNumbers).mapToInt(Integer::parseInt)
                                         .toArray();
    }


}
