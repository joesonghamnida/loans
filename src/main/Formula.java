package main;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Formula {

    //https://www.thebalance.com/loan-payment-calculations-315564

    //simple interest
    //principal x rate x time
    //a = p(1 + rt)
    //convert r to a decimal

    //https://www.calculatorsoup.com/calculators/financial/compound-interest-calculator.php
    //compound interest
    //amount = p(1+r/n)^(nt)

    //amortization
    //payment = amount / discount factor
    //n: payments per year x # of years
    //(p)eriodic interest rate: annual rate / # payments per year
    //discount factor: ([(1+p)^n]-1) / [p(1+p)^n]

    //https://docs.oracle.com/javase/8/docs/api/java/util/Currency.html

    //TODO: need something to deal with rounding
    /* sample
    public static double roundToDecimals(double d, int c)
    {
        int temp = (int)(d * Math.pow(10 , c));
        return ((double)temp)/Math.pow(10 , c);
    }*/

    public static double percentToDecimal(double percent){
        double rate = percent / 100;
        return rate;
    }

    public static double monthsToYears(double months){
        double years = months / 12;
        return years;
    }

    public static double simpleInterest(double principal, double rate, double years){
        double amount = 0.0;
        double interest = (1 + (rate * years));
        amount = principal * interest;
        return amount;
    }

    public static double compoundInterest(double principal, double rate, int months){
        double amount = 0.0;

        return amount;
    }

    public static double amortization(){
        double amount = 0.0;

        return amount;
    }
}
