package tests;

import main.Formula;
import org.junit.*;

import main.Formula.*;

public class FormulaTests {

    @Test
    public void PercentToDecimal(){
        Assert.assertTrue(.01 == Formula.percentToDecimal(1));
        Assert.assertTrue(.1 == Formula.percentToDecimal(10));
    }

    @Test
    public void monthsToYears(){
        Assert.assertTrue(1 == Formula.monthsToYears(12));
        Assert.assertTrue(2 == Formula.monthsToYears(24));
        Assert.assertFalse(3 == Formula.monthsToYears(25));
    }

    @Test
    public void CalculateSimpleInterest(){
        Assert.assertTrue(10500 == Formula.simpleInterest(10000, .01, 5));
        Assert.assertTrue(10500 == Formula.simpleInterest(10000, .01, 5));
        double years = Formula.monthsToYears(32);
        double rate = Formula.percentToDecimal(23);
        //TODO: deal with how Java does numbers, re: double. Needs to be done for all non-integers
        Assert.assertTrue(20603.99 == Formula.simpleInterest(12765, rate, years));
    }

    @Test
    public void CalculateCompoundInterest(){
        //Formula.compoundInterest();
    }

    @Test
    public void CalculateAmortization(){
        //Formula.amortization();
    }
}
