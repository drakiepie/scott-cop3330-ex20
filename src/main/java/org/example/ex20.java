package org.example;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Exercise 20 Solution
 *  Copyright 2021 Drake Scott
 */

public class ex20 {
    static Scanner input = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("$#,##0.00");


    public static double Illinois(double amount){
        double tax = amount * 0.08;
        return tax;
    }

    public static double Wisconsin(double amount, String county){
        double tax;
        if (county.equals("dunn")){
            tax = amount * 0.055;
        } else if (county.equals("eauclaire")){
            tax = amount * 0.054;
        } else {
            tax = amount * 0.05;
        }
        return tax;
    }

    public static void main(String[] args) {
        System.out.print("What is the order amount? ");
        double amount = input.nextDouble();

        System.out.print("What state do you live in? ");
        String state = input.next();
        state = state.toLowerCase();

        double tax;
        if (state.equals("wisconsin")) {
            System.out.print("What county do you live in? ");
            input.nextLine();
            String county;
            county = input.nextLine();
            county = county.replaceAll("\\s","");
            county = county.toLowerCase();
            tax = Wisconsin(amount, county);
        }
        else if (state.equals("illinois")) {
            tax = Illinois(amount);
        } else {
            tax = 0;
        }

        double finalAmount = (amount + tax);
        String outputString = "The tax is " + df.format(tax) + ".\nThe total is " + df.format(finalAmount) + ".";
        System.out.print(outputString);

    }
}
