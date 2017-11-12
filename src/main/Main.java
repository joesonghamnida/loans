package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //current loan balance

    //interest rate

    //need to handle multiple loans and interest rates

    //goal to pay it off

    //budget

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Hello! please select an option: ");

        int exit = 0;
        while(exit == 0){
            System.out.println("1: Calculate interest for a simple loan");
            System.out.println("2: Calculate interest for a compound loan");
            System.out.println("0: Exit program");

            String choice = keyboard.nextLine();

            if (choice.equals("1")){
                System.out.println("Principal:");
                BigDecimal principal = BigDecimal.valueOf(Integer.valueOf(keyboard.nextLine()));
                System.out.println("Rate:");
                BigDecimal rate = BigDecimal.valueOf(Integer.valueOf(keyboard.nextLine()));
                double years = Double.valueOf(keyboard.nextLine());
                Formula.simpleInterest(principal, rate, years);
            }
            else if(choice.equals("2")){
                System.out.println("Principal:");
                BigDecimal principal = BigDecimal.valueOf(Integer.valueOf(keyboard.nextLine()));
                System.out.println("Rate:");
                BigDecimal rate = BigDecimal.valueOf(Integer.valueOf(keyboard.nextLine()));
                int compoundingUnits = Integer.valueOf(keyboard.nextLine());
                double years = Double.valueOf(keyboard.nextLine());
                Formula.compoundInterest(principal,rate,compoundingUnits,years);
            }
            else if(choice == "0"){
                System.out.println("Goodbye");
                exit = 1;
            }
            else {
                System.out.println("Please enter a valid choice");
            }
        }
        System.exit(0);

    }

    public static ArrayList<Double> addLoan(){

        //principal, interest rate
        ArrayList<Double> loan = new ArrayList<>();

        return loan;
    }
}
