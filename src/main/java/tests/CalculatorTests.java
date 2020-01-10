package tests;

import Pages.CalculatorPage;
import Utils.driverManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CalculatorTests extends CalculatorPage {

    public CalculatorTests() throws Exception {
    }

    @Test
    public void Addition(){
        String result = Addition(1, 1);
        Assert.assertEquals(result, "2");
    }

    @AfterTest
    public void closeCalculator(){
        driverManager.closeDriver();
    }
}
