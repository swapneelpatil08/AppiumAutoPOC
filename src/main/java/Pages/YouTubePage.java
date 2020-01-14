package Pages;

import Utils.driverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class YouTubePage extends driverManager {

    private AppiumDriver<MobileElement> driver;

    public YouTubePage() throws Exception {
        this.driver = driverManager.openDriver(appToBeOpened.Youtube);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

//    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Search\"]\n")
//    private MobileElement searchButton;

    @AndroidFindBy(accessibility = "Search")
    private MobileElement searchButton;

    @AndroidFindBy(id = "search_edit_text")
    private MobileElement search_edit_text;

    @AndroidFindBy(id = "title")
    private List<MobileElement> playlistItemsTitle;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<MobileElement> suggestionList;

    public void search(String searchText) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(webDriver -> searchButton.isDisplayed());
        searchButton.click();
        search_edit_text.sendKeys(searchText);
    }

    public void selectFirstResult(String searchText) {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(webDriver -> suggestionList.get(0).isDisplayed());

        suggestionList.get(0).click();
    }

    public String getTextOfFirstResult(){
        String value = playlistItemsTitle.get(0).getText();
        System.out.println("Value: " + value);
        return value;
    }
}