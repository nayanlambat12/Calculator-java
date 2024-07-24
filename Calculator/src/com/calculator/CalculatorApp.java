package com.calculator;

import java.util.Scanner;

public class CalculatorApp {

    private static CalculatorService calculatorService = new CalculatorService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter first number (or type 'exit' to quit): ");
            String input1 = scanner.next();
            if (input1.equalsIgnoreCase("exit")) {
                break;
            }

            double num1 = parseDouble(input1);

            System.out.println("Enter second number: ");
            String input2 = scanner.next();
            double num2 = parseDouble(input2);

            System.out.println("Select operation: (+, -, *, /)");
            String operation = scanner.next();

            try {
                double result = performOperation(num1, num2, operation);
                System.out.println("Result: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    private static double parseDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            System.exit(1);
            return 0; // This line will never be reached, added to satisfy the compiler
        }
    }

    private static double performOperation(double num1, double num2, String operation) {
        switch (operation) {
            case "+":
                return calculatorService.add(num1, num2);
            case "-":
                return calculatorService.subtract(num1, num2);
            case "*":
                return calculatorService.multiply(num1, num2);
            case "/":
                return calculatorService.divide(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}

