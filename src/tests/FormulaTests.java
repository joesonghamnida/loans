package tests;

import main.Formula;
import org.junit.*;

import main.Formula.*;

import java.math.BigDecimal;

public class FormulaTests {

    @Test
    public void PercentToDecimal(){
        BigDecimal expected = new BigDecimal(0);
        System.out.println();
        Assert.assertTrue( (expected = expected.valueOf(0.01)).equals(Formula.percentToDecimal(1)));
        Assert.assertTrue((expected = expected.valueOf(0.1)).equals(Formula.percentToDecimal(10)));
    }

    @Test
    public void monthsToYears(){
        Assert.assertTrue(1 == Formula.monthsToYears(12));
        Assert.assertTrue(2 == Formula.monthsToYears(24));
        Assert.assertFalse(3 == Formula.monthsToYears(25));
    }

    @Test
    public void CalculateSimpleInterest(){

        BigDecimal expected = new BigDecimal(0);

        expected = expected.valueOf(10500.00);
        expected = expected.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        Assert.assertTrue(expected.equals(Formula.simpleInterest(BigDecimal.valueOf(10000.0), BigDecimal.valueOf(0.01), 5)));

        double years = Formula.monthsToYears(32);
        BigDecimal rate = Formula.percentToDecimal(23);
        System.out.println(Formula.simpleInterest(BigDecimal.valueOf(12765), rate, years));

        expected = BigDecimal.valueOf(20594.20);
        expected = expected.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        Assert.assertTrue(expected.equals(Formula.simpleInterest(BigDecimal.valueOf(12765), rate, years)));

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
