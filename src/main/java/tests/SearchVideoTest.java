package tests;

import Pages.HomePage;
import Pages.SearchFieldPage;
import Utils.driverManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SearchVideoTest extends SearchFieldPage {

    public SearchVideoTest() throws Exception {
    }
    HomePage homePage = new HomePage(androidDriver);

    @Test
    public void search(){
        String searchText = "Appium Step by Step for Beginners";
        homePage.clickSearch();
        setSearchText(searchText);
        selectFirstResult(searchText);
        String textOfFirstResult = getTextOfFirstResult();
        Assert.assertEquals(textOfFirstResult, searchText);
    }

    @AfterTest
    public void CloseYoutube(){
        closeDriver();
    }
}
