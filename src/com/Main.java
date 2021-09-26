package com;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> romanNumerals = Map.of(
                "I", 1,
                "II", 2,
                "III", 3,
                "IV", 4,
                "V", 5,
                "VI", 6,
                "VII", 7,
                "VIII", 8,
                "IX", 9,
                "X", 10
        );
        Scanner sc = new Scanner(System.in);
        String inputString = "";
        if (sc.hasNextLine()) {
            inputString = sc.nextLine();
        } else {
            System.out.println("throws Exception");
            return;
        }
        String[] input =  inputString.split(" ");
        if (input.length != 3) {
            System.out.println("throws Exception out of bounds");
            return;
        }
        if (isDigit(input[0]) && isDigit(input[2])) {
            System.out.println(execute(Integer.parseInt(input[0]), Integer.parseInt(input[2]), input[1].charAt(0)));
        } else if (romanNumerals.get(input[0]) != null && romanNumerals.get(input[2]) != null){
            execute(romanNumerals.get(input[0]), romanNumerals.get(input[2]), input[1].charAt(0));
        } else {
            System.out.println("throws Exception не 2 цифры");
        }
        sc.close();
    }

    private static int execute(int a, int b, char op) throws NumberFormatException {
        switch (op) {
            case '+' :
                return a + b;
            case '-' :
                return a - b;
            case '*' :
                return a * b;
            case '/' :
                  if (b != 0) {
                    return a / b;
                  } else {
                    throw new ArithmeticException("Division by 0!");
                  }
            default :
                System.out.println("Unknown operator");
                break;
        }
        return 0;
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
