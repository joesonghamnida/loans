package main;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;

public class Formula {

    //https://docs.oracle.com/javase/8/docs/api/java/util/Currency.html
    //http://www.javapractices.com/topic/TopicAction.do?Id=13

    public static BigDecimal percentToDecimal(double percent){
        BigDecimal rate = (BigDecimal.valueOf(percent / 100));
        return rate;
    }

    public static double monthsToYears(double months){
        double years = months / 12;
        return years;
    }

    //https://www.thebalance.com/loan-payment-calculations-315564

    //simple interest
    //principal x rate x time
    //a = p(1 + rt)
    //convert r to a decimal
    public static BigDecimal simpleInterest(BigDecimal principal, BigDecimal rate, double years){
        BigDecimal amount;
        BigDecimal interest = (rate.multiply(BigDecimal.valueOf(years)));
        BigDecimal one = new BigDecimal("1.0");
        interest = interest.add(one);
        amount = principal.multiply(interest);
        amount = amount.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return amount;
    }


    /*https://www.calculatorsoup.com/calculators/financial/compound-interest-calculator.php
    compound interest
    amount = p(1+r/n)^(nt)
    p = principal
    r = annual nominal interest rate as a decimal
    n = number of compounding units per unit
    t = time involved in years
    */
    public static BigDecimal compoundInterest(BigDecimal principal, BigDecimal rate, int compoundingUnits, double years){
    	BigDecimal amount;

    	amount = amount.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return amount;
    }

    //amortization
    //payment = amount / discount factor
    //n: payments per year x # of years
    //(p)eriodic interest rate: annual rate / # payments per year
    //discount factor: ([(1+p)^n]-1) / [p(1+p)^n]
    public static double amortization(){
        double amount = 0.0;

        return amount;
    }
}
