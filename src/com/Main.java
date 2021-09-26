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
        System.out.println(romanNumerals.get("X"));
        Scanner sc = new Scanner(System.in);
        String inputString = "";
        if (sc.hasNextLine()) {
            inputString = sc.nextLine();
        } else {
            System.out.println("throws Exception");
            return;
        }
        String[] input =  inputString.split(" ");
        if (input.length > 3) {
            System.out.println("throws Exception");
            return;
        }
        //execute(input[0], input[2], input[1].charAt(0));
        sc.close();
    }

    private static void execute(int a, int b, char op){
        switch (op) {
            case '+' :
                System.out.println(a + b);
                break;
            case '-' :
                System.out.println(a - b);
                break;
            case '*' :
                System.out.println(a * b);
                break;
            case '/' :
                System.out.println(b != 0 ? a / b : "Division by 0!");
                break;
            default :
                System.out.println("Unknown operator");
                break;
        }
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
