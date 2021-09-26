package com;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> romanNumerals = new HashMap<>();
        romanNumerals.put("I", 1);
        romanNumerals.put("II", 2);
        romanNumerals.put("III", 3);
        romanNumerals.put("IV", 4);
        romanNumerals.put("V", 5);
        romanNumerals.put("VI", 6);
        romanNumerals.put("VII", 7);
        romanNumerals.put("VIII", 8);
        romanNumerals.put("IX", 9);
        romanNumerals.put("X", 10);

        Scanner sc = new Scanner(System.in);
        String inputString;

        if (sc.hasNextLine()) {
            inputString = sc.nextLine();
        } else {
            System.out.println("throws Exception");
            return;
        }

        String[] input = inputString.split(" ");
        if (input.length != 3) {
            System.out.println("throws Exception out of bounds");
            return;
        }

        String firstDigit = input[0];
        String secondDigit = input[2];
        char operator = input[1].charAt(0);

        if (isDigit(firstDigit) && isDigit(secondDigit) && inBounds(firstDigit) && inBounds(secondDigit)) {
            System.out.println(execute(Integer.parseInt(firstDigit),Integer.parseInt(secondDigit), operator));
        } else if (romanNumerals.get(firstDigit) != null && romanNumerals.get(secondDigit) != null) {
            int romanResult = execute(romanNumerals.get(firstDigit), romanNumerals.get(secondDigit), operator);

            if (romanResult < 1) {
                System.out.println("throws Exception wrong Romanian numbers");
            } else if (romanResult <= 10) {
                System.out.println(getKeyByValue(romanNumerals, romanResult));
            } else {
                System.out.println("X" + getKeyByValue(romanNumerals, romanResult - 10));
            }
        } else {
            System.out.println("throws Exception wrong numbers");
        }
        sc.close();
    }

    private static int execute(int a, int b, char op) throws ArithmeticException {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b != 0) {
                    return a / b;
                } else {
                    throw new ArithmeticException("Division by 0!");
                }
            default:
                System.out.println("throws Exception Unknown operator");
                break;
        }
        return 1000;
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean inBounds(String s) {
        int n = Integer.parseInt(s);
        return n > 0 && n < 11;
    }

    public static String getKeyByValue(HashMap<String, Integer> map, Integer value) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
