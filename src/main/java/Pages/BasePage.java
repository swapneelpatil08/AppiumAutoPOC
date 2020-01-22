package Pages;

import Utils.driverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends driverManager {

    private static final int TIMEOUT = 50; //seconds
    private WebDriverWait wait;

    protected static void waitForElementToAppear(WebElement element){
        WebDriverWait wait = new WebDriverWait(androidDriver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToDisappear(WebElement element) {
    }

    protected void waitForTextToDisappear(By locator, String text) {
    }

    protected void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(androidDriver, TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}