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
        if (input.length > 3) {
            System.out.println("throws Exception");
            return;
        }
        if (isDigit(input[0]) && isDigit(input[2])) {
            execute(Integer.parseInt(input[0]), Integer.parseInt(input[2]), input[1].charAt(0));
        } else if (romanNumerals.get(input[0]) != null && romanNumerals.get(input[2]) != null){
            execute(romanNumerals.get(input[0]), romanNumerals.get(input[2]), input[1].charAt(0));
        } else {
            System.out.println("throws Exception");
        }
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
