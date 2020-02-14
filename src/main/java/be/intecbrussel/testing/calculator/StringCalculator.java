package be.intecbrussel.testing.calculator;

public class StringCalculator {

    public int add(String numbers){
        int number1=0;
        int number2=0;
        int number3=0;
        if (numbers.equals("")){
            return 0;
        }
        if(numbers.split(",").length==1){
            number2=Integer.parseInt(numbers.split(",")[0]);
        }
        if(numbers.split(",").length==2){
            number2=Integer.parseInt(numbers.split(",")[0]);
            number3=Integer.parseInt(numbers.split(",")[1]);
        }

        return number1+number2+number3;
    }


}
