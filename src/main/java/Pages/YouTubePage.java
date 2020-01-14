package Pages;

import Utils.driverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @AndroidFindBy(id = "search_layout")
    private MobileElement result;

    @AndroidFindBy(id = "search_layout")
    private MobileElement playlistItems;


    public void search(String searchText) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(webDriver -> searchButton.isDisplayed());
        searchButton.click();
        search_edit_text.sendKeys(searchText);
    }

    public void selectFirstResult(String searchText) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(webDriver -> result.isDisplayed());
        System.out.println("result.isDisplayed(): " + result.isDisplayed());
        System.out.println("playlistItems.isDisplayed(): " + playlistItems.isDisplayed());

//        System.out.println("SearchText" + playlistItems.findElementByXPath("//android.widget.TextView[contains(., '" + searchText + "')]").isDisplayed());

//        List<MobileElement> list = driver.findElements(By.className("android.widget.TextView"));
//        System.out.println("-----"+list);
//        result.findElementByXPath("//android.widget.ImageView[contains(@content-desc(), 'Edit suggestion " + searchText + "')]").click();
//        result.findElementByXPath().click();
    }

    public String getTextOfFirstResult(String searchText){
        String value = result.findElementByXPath("//android.widget.TextView]").getText();
        System.out.println("Value: " + value);
        return value;
    }
}