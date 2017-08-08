package main;

import java.math.BigDecimal;
import java.math.MathContext;

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
    //TODO: issue with payment and will have to figure out how to have initial value and decreasing value for mult loans

    public static BigDecimal calculateInitialPayment(BigDecimal principal, int paymentsPerYear, int numberOfYears){
        BigDecimal initialPayment;

        initialPayment = principal.divide(BigDecimal.valueOf(paymentsPerYear * numberOfYears));

        return initialPayment;
    }

    public static BigDecimal amortization(BigDecimal initialPayment, BigDecimal principal, BigDecimal rate, int paymentsPerYear, int numberOfYears){

        int years = paymentsPerYear * numberOfYears;
        BigDecimal n = BigDecimal.valueOf(years);
        BigDecimal principalTwo = principal;

        principal = principalFirstPart(principal, n);
        principalTwo = principalSecondPart(principalTwo, n);

        BigDecimal payment = principalDivision(principal, principalTwo);

        return payment;
    }

    //handles multiplication
    public static BigDecimal principalFirstPart(BigDecimal principal, BigDecimal n){

        principal = principal.add(one);
        principal = principal.multiply(n);
        principal = principal.subtract(one);

        return principal;
    }

    //multiplication second part
    public static BigDecimal principalSecondPart(BigDecimal principalTwo, BigDecimal n){

        BigDecimal principalTwoHolding = principalTwo;
        principalTwo = principalTwo.add(one);
        principalTwo = principalTwo.multiply(principalTwoHolding);
        principalTwo = principalTwoHolding.multiply(n);

        return principalTwo;
    }

    //amortization division
    //TODO: bug in payment with 0 payment
    public static BigDecimal principalDivision(BigDecimal principal, BigDecimal principalTwo){
        BigDecimal discountFactor = principal.divide(principalTwo);

        BigDecimal payment = BigDecimal.valueOf(0);
        payment = payment.divide(discountFactor, MathContext.DECIMAL64);
        payment = payment.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return payment;
    }
}
