package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(7, 9);
        System.out.println(arithmeticCalculator.calculate(Operation.SUBTRACT));
        System.out.println(arithmeticCalculator.calculate(Operation.MULTIPLY));
        System.out.println(arithmeticCalculator.calculate(Operation.ADD));
    }
}
