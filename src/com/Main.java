package com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
        execute(input[0], input[2], input[1].charAt(0));
        sc.close();
    }

    private static void execute(String a, String b, char op){
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
}
