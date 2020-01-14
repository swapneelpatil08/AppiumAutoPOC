package tests;

import Pages.YouTubePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class YoutubeTests extends YouTubePage {

    public YoutubeTests() throws Exception {
    }

    @Test
    public void search(){
        String searchText = "Appium Step by Step for Beginners";
        search(searchText);
        selectFirstResult(searchText);
        String textOfFirstResult = getTextOfFirstResult();
        Assert.assertEquals(textOfFirstResult, searchText);
    }

    @AfterTest
    public void CloseYoutube(){
        closeDriver();
    }
}
