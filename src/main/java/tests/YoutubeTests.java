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
        String searchText = "appium tutorial for beginners";
        search(searchText);
        selectFirstResult(searchText);
        String value = getTextOfFirstResult(searchText);
        Assert.assertEquals(value, "Appium Step by Step for Beginners");
    }

    @AfterTest
    public void CloseYoutube(){
        closeDriver();
    }
}
