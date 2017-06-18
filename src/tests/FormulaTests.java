package tests;

import main.Formula;
import org.junit.*;

import main.Formula.*;

public class FormulaTests {

    @Test
    public void CalculateSimpleInterest(){
        Formula.simpleInterest();
    }

    @Test
    public void CalculateCompoundInterest(){
        Formula.compundInterest();
    }

    @Test
    public void CalculateAmortization(){
        Formula.amortization();
    }
}
