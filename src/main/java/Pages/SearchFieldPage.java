package Pages;

import Utils.driverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchFieldPage extends driverManager {

    private AndroidDriver<MobileElement> driver;

    public SearchFieldPage() throws Exception {
        this.driver = driverManager.openDriver(appToBeOpened.Youtube);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public SearchFieldPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "search_edit_text")
    private MobileElement search_edit_text;

    @AndroidFindBy(id = "title")
    private List<MobileElement> playlistItemsTitle;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<MobileElement> suggestionList;



    public void setSearchText(String searchText)
    {
        search_edit_text.clear();
        search_edit_text.sendKeys(searchText);
    }

    public void selectFirstResult(String searchText) {
        suggestionList.get(0).click();
    }

    public String getTextOfFirstResult(){
        String value = playlistItemsTitle.get(0).getText();
        System.out.println("Value: " + value);
        return value;
    }

    public void playFirstVideo(){
        playlistItemsTitle.get(0).click();

    }

    public void pressEnter() {
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}