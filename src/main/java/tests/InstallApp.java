package tests;

import Utils.driverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InstallApp extends driverManager {

    private AndroidDriver<MobileElement> driver;

    public InstallApp() throws Exception {
        this.driver = driverManager.openDriver(driverManager.appToBeOpened.newApp);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @Test
    public void isAppInstalled() {
        boolean isAppInstalled = driver.isAppInstalled("com.facebook.katana");
        Assert.assertTrue(isAppInstalled);
    }

    @Test
    public void closeApp() {
        driver.closeApp();
    }

    @Test
    public void removeApp() {
        driver.removeApp("com.facebook.katana");
    }
}
