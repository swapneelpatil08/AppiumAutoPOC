package tests;

import Pages.HomePage;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


public class HomePageTests extends HomePage {

    public HomePageTests() throws Exception {
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                { "Home" },
                { "Trending" },
                { "Subscriptions" },
                { "Activity" },
                { "Library" }};
    }

    @Test
    public void verifyLogo(){
        boolean pageLogoDisplayed = isPageLogoDisplayed() ;
        System.out.println(pageLogoDisplayed);
        Assert.assertTrue(pageLogoDisplayed,"true");
    }

    @Test(dataProvider = "data-provider")
    public void switchTabs(String data){
        MobileElement ele = clickHomeIcons(data);
        boolean result = isSelected(ele);
        Assert.assertTrue(result,"true");
    }


}
