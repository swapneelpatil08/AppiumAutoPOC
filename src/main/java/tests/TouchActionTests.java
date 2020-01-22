package tests;

import Pages.HomePage;
import Pages.SearchFieldPage;
import Pages.TouchActionsPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TouchActionTests extends TouchActionsPage {

    public TouchActionTests() throws Exception {
    }
    SearchFieldPage searchFieldPage = new SearchFieldPage(androidDriver);
    HomePage homePage = new HomePage(androidDriver);

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {"cypress"},
                {"Mobile test"},
                {"123456"},
                {"thoughts"}};
    }

    @Test(dataProvider = "data-provider")
    public void SeekBarTest(String data){
        homePage.clickSearch();
        searchFieldPage.setSearchText(data);
        searchFieldPage.pressEnter();
        searchFieldPage.playFirstVideo();
        skipAd();
        setPlayPause();
        moveSeekBar();
        minimizeVideo();
    }

    @AfterTest
    public void CloseYoutube(){
        closeDriver();
    }
}
