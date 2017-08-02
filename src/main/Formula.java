package main;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;

public class Formula {

    //https://docs.oracle.com/javase/8/docs/api/java/util/Currency.html
    //http://www.javapractices.com/topic/TopicAction.do?Id=13
	
	public static BigDecimal one = new BigDecimal("1.0");

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

    //am going to need to do different kinds of compound interest
    public static BigDecimal compoundInterest(BigDecimal principal, BigDecimal rate, int compoundingUnits, double years){
    	BigDecimal amount;
    	Double exponent = compoundingUnits * years;
    	BigDecimal interest = (rate.divide(BigDecimal.valueOf(years)));
    	interest = interest.add(one);
    	interest = interest.multiply(BigDecimal.valueOf(exponent));
    	amount = principal.multiply(interest);
    	amount = amount.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return amount;
    }

    //amortization
    //payment = amount / discount factor
    //n: payments per year x # of years
    //(p)eriodic interest rate: annual rate / # payments per year
    //discount factor: ([(1+p)^n]-1) / [p(1+p)^n]
    //TODO: look up how bigdecimal handles division
    public static BigDecimal amortization(BigDecimal payment, BigDecimal principal, BigDecimal rate, int paymentsPerYear, int numberOfYears){

        int years = paymentsPerYear * numberOfYears;
        BigDecimal n = BigDecimal.valueOf(years);
        BigDecimal principalTwo = principal;

        //multiplication first part. Will need to refactor both multiplications and division
        principal = principal.add(one);
        principal = principal.multiply(n);
        principal = principal.subtract(one);

        //multiplication second part
        BigDecimal principalTwoHolding = principalTwo;
        principalTwo = principalTwo.add(one);
        principalTwo = principalTwo.multiply(principalTwoHolding);
        principalTwo = principalTwoHolding.multiply(n);

        //division
        BigDecimal discountFactor = principal.divide(principalTwo);

        payment = payment.divide(discountFactor);

        return payment;
    }
}
