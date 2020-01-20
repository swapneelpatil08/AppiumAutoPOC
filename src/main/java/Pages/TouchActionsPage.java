package Pages;

import Utils.driverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

public class TouchActionsPage extends driverManager {
    private AndroidDriver<MobileElement> driver;

    public TouchActionsPage() throws Exception {
        this.driver = driverManager.openDriver(driverManager.appToBeOpened.Youtube);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(id = "player_control_previous_button")
    private MobileElement previousButton;

    @AndroidFindBy(id = "player_control_play_pause_replay_button")
    private MobileElement playPauseButton;

    @AndroidFindBy(id = "player_control_next_button")
    private MobileElement nextButton;

    @AndroidFindBy(id = "fullscreen_button")
    private MobileElement fullScreenButton;

    @AndroidFindBy(className = "android.widget.SeekBar")
    private MobileElement seekBar;

    @AndroidFindBy(id = "player_learn_more_button")
    private MobileElement visitAdvertiser;

//    public AndroidDriver<MobileElement> getDriver() {
//        return driver;
//    }

    public void moveSeekBar(){
        int start = seekBar.getLocation().getX();
        int end = seekBar.getSize().getWidth();
        int y = seekBar.getLocation().getY();

        TouchAction action = new TouchAction(this.driver);
        action.press(PointOption.point(start, y)).moveTo(PointOption.point(end, y)).release().perform();
    }

    public void waitForAdvertiserToDisappear(){
        if (visitAdvertiser.isDisplayed()) {
            BasePage base = new BasePage(driver);
            base.waitForElementToDisappear(By.id("player_learn_more_button"));
        }
    }
}
