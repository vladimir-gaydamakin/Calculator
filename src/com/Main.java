package com;

import java.io.IOException;
import java.util.*;

public class Main {
    static HashMap<String, Integer> romanNumeral = new HashMap<>();

    static {
        romanNumeral.put("I", 1);
        romanNumeral.put("II", 2);
        romanNumeral.put("III", 3);
        romanNumeral.put("IV", 4);
        romanNumeral.put("V", 5);
        romanNumeral.put("VI", 6);
        romanNumeral.put("VII", 7);
        romanNumeral.put("VIII", 8);
        romanNumeral.put("IX", 9);
        romanNumeral.put("X", 10);
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String inputString;

        if (sc.hasNextLine()) {
            inputString = sc.nextLine();
        } else {
            throw new IOException("Enter expression");
        }

        String[] input = inputString.split(" ");
        if (input.length != 3) {
            throw new IOException("Wrong expression");
        }

        String firstDigit = input[0];
        String secondDigit = input[2];
        char operator = input[1].charAt(0);

        if (isDigit(firstDigit) && isDigit(secondDigit) &&
                inBounds(Integer.parseInt(firstDigit)) &&
                inBounds(Integer.parseInt(secondDigit))) {

            System.out.println(executeExpression(Integer.parseInt(firstDigit), Integer.parseInt(secondDigit), operator));

        } else if (romanNumeral.get(firstDigit) != null && romanNumeral.get(secondDigit) != null) {
            int romanResult = executeExpression(romanNumeral.get(firstDigit), romanNumeral.get(secondDigit), operator);
            if (romanResult < 1) {
                throw new IOException("Can't evaluate Roman numbers");
            } else {
                toRoman(romanResult);
            }
        } else {
            throw new IOException("Wrong values");
        }
        sc.close();
    }

    private static int executeExpression(int a, int b, char op) throws IOException {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> throw new IOException("Unknown operator");
        };
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean inBounds(int n) {
        return n > 0 && n < 11;
    }

    private static void toRoman(int n) {
        int[] number = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumber = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < number.length; i++) {
            int repeat = n / number[i];
            for (int j = 0; j < repeat; j++) {
                System.out.print(romanNumber[i]);
                n = n - number[i];
            }
        }
    }
}
