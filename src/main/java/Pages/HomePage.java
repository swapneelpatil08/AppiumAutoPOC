package Pages;

import Utils.driverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.TouchAction;


public class HomePage extends driverManager {

    private AppiumDriver<MobileElement> driver;

    public HomePage() throws Exception {
        this.driver = driverManager.openDriver(appToBeOpened.Youtube);
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

    public boolean isSelected(MobileElement element){
        return element.isSelected();
    }

    public boolean isPageLogoDisplayed(){
        return logo.isDisplayed();
    }

    public void clickOnSearchIcon(){
        searchButton.click();
    }

    public void clickOnUserAccount(){
        account.click();
    }
}
