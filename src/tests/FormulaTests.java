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
        BigDecimal expected = new BigDecimal(0);
        BigDecimal rate = Formula.percentToDecimal(10);

        expected = expected.valueOf(11000.00);
        expected = expected.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        Assert.assertTrue(expected.equals(Formula.compoundInterest(BigDecimal.valueOf(10000.0),rate, 1, 1)));

        rate = Formula.percentToDecimal(10);
        expected = expected.valueOf(9046997.88);
        expected = expected.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        System.out.println(Formula.compoundInterest(BigDecimal.valueOf(1234567.0),rate, 12, 20));
        Assert.assertTrue(expected.equals(Formula.compoundInterest(BigDecimal.valueOf(1234567.0),rate, 12, 20)));
    }

    @Test
    public void CalculateAmortization(){
        BigDecimal expected = new BigDecimal(0);
        BigDecimal rate = Formula.percentToDecimal(10);

        expected = expected.valueOf(100);
        expected = expected.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        System.out.println(((Formula.amortization(BigDecimal.valueOf(100), rate, 1, 1).toString())));
        Assert.assertTrue(expected.equals(Formula.amortization(BigDecimal.valueOf(100), rate, 1, 1)));

        expected = expected.valueOf(400.76);
        expected = expected.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        rate = BigDecimal.valueOf(.00625);
        System.out.println(Formula.amortization(BigDecimal.valueOf(20000), rate, 12, 5));
        Assert.assertTrue(expected.equals(Formula.amortization(BigDecimal.valueOf(20000), rate, 12, 5)));
    }
}
