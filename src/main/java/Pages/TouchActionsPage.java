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

import java.util.List;

public class TouchActionsPage extends driverManager {
    private AndroidDriver<MobileElement> driver;
    BasePage bp = new BasePage();

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

    @AndroidFindBy(id ="skip_ad_button_text")
    private  List<MobileElement> skipAdButton;

    @AndroidFindBy(className = "android.view.View")
    private MobileElement videoFrame;

    @AndroidFindBy(id = "player_overlays")
    private MobileElement playerOverlays;


    @AndroidFindBy(id = "player_learn_more_button")
    private List<MobileElement> adOnScreen;

    @AndroidFindBy(accessibility = "Minimize")
    private MobileElement minimize;

    @AndroidFindBy(id = "search_query")
    private MobileElement searchField;

    @AndroidFindBy(id = "search_clear")
    private MobileElement searchClear;

    public void moveSeekBar(){
        int start = seekBar.getLocation().getX();
        int end = seekBar.getSize().getWidth() - 300;
        int y = seekBar.getLocation().getY();
        TouchAction action = new TouchAction(this.driver);
        action.press(PointOption.point(start, 670)).moveTo(PointOption.point(end, 670)).release().perform();
    }

    public void skipAd(){
            while (adOnScreen.size()>0){
                if(skipAdButton.size()>0){
                    skipAdButton.get(0).click();
                }
        }}

    public void setPlayPause(){
       seekBar.click();
       if(playPauseButton.isDisplayed()){
           playPauseButton.click();
       }

    }

    public void minimizeVideo(){
        BasePage.waitForElementToAppear(minimize);
        minimize.click();
    }

    public void searchField(){
        searchField.click();
    }
}
