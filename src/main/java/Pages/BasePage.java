package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final int TIMEOUT = 5; //seconds
    protected AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;


    public BasePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void waitForElementToAppear(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }

    protected void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}