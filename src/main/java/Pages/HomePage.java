package Pages;

import Utils.driverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;


public class HomePage extends driverManager {

    private AndroidDriver<MobileElement> driver;

    public HomePage() throws Exception {
        this.driver = driverManager.openDriver(appToBeOpened.Youtube);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public HomePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(accessibility = "Home")
    private MobileElement homeIcon;

    @AndroidFindBy(accessibility = "Trending")
    private MobileElement trendingIcon;

    @AndroidFindBy(accessibility = "Subscriptions")
    private MobileElement subscription;

    @AndroidFindBy(accessibility = "Activity")
    private MobileElement activity;

    @AndroidFindBy(accessibility = "Library")
    private MobileElement library;

    @AndroidFindBy(accessibility = "Search")
    private MobileElement searchButton;

    @AndroidFindBy(accessibility = "Account")
    private MobileElement account;

    @AndroidFindBy(id = "youtube_logo")
    private MobileElement logo;

    @AndroidFindBy(id = "com.google.android.youtube:id/results\n")
    private List<MobileElement> thumbnails;

    @AndroidFindBy(id = "search_edit_text")
    private MobileElement search_edit_text;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<MobileElement> suggestionList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Appium Tutorial']")
    private MobileElement AppiumTutorial;

    @AndroidFindBy(id = "floaty_close_button")
    private MobileElement closePlayingVideoButton;

    @AndroidFindBy(accessibility = "Search")
    private List<MobileElement> searchOnHomePage;

    @AndroidFindBy(id = "search_query")
    private List<MobileElement> searchQuery;

    public MobileElement clickHomeIcons(String icon) {
        switch (icon) {
            case "Home":
                homeIcon.click();
                return homeIcon;
            case "Trending":
                trendingIcon.click();
                return trendingIcon;
            case "Subscriptions":
                subscription.click();
                return subscription;
            case "Activity":
                activity.click();
                return activity;
            case "Library":
                library.click();
                return library;
            case "Search":
                searchButton.click();
                return searchButton;
            case "Account":
                account.click();
                return account;
        }
        return null;
    }

    public boolean isSelected(MobileElement element) {
        return element.isSelected();
    }

    public boolean isPageLogoDisplayed() {
        return logo.isDisplayed();
    }

    public void clickOnSearchIcon() {
        searchButton.click();
    }

    public void clickOnUserAccount() {
        account.click();
    }

    public void scrollToView() {

        searchButton.click();
        search_edit_text.sendKeys("Appium Tutorial");
        suggestionList.get(0).click();
        TouchAction touchAction;
        touchAction = new TouchAction(driver);
        boolean found = false;
        while (!found) {
            try {
                AppiumTutorial.isDisplayed();
                found = true;
            } catch (Exception e) {
                touchAction.press(PointOption.point(0, 1600))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(0, 210))
                        .release()
                        .perform();
            }
        }
    }

    public void clickSearch() {
        if(searchOnHomePage.size()>0) {
            searchOnHomePage.get(0).click();
        }
        else if(searchQuery.size()>0){
            searchQuery.get(0).click();
        }
    }

    public void closePlayingVideo() {
        if (closePlayingVideoButton.isDisplayed()) {
            closePlayingVideoButton.click();
        }
    }

}
