package ru.skillbox;

public class Main {

    public static void main(String[] args)
    {
        ArithmeticCalculator calculator = new ArithmeticCalculator(5,10);

        System.out.println(calculator.calcculate(Operations.MULTIPLY));
    }
}
