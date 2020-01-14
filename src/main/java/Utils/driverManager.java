package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class driverManager {
    public enum appToBeOpened {Chrome, Calculator, Youtube}

    public static AppiumDriver<MobileElement> appiumDriver;


    public static AppiumDriver<MobileElement> openDriver(appToBeOpened app) throws Exception {

        appiumDriver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), getCapabilities(app));
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return appiumDriver;
    }


    private static DesiredCapabilities getCapabilities(appToBeOpened appName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.9.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "9");
//        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appWaitActivity", "*");

        if (appName == appToBeOpened.Calculator) capabilities = getCapabilitiesForCalculator(capabilities);
        if (appName == appToBeOpened.Youtube) capabilities = getCapabilitiesForYouTube(capabilities);
        if (appName == appToBeOpened.Chrome) capabilities = getCapabilitiesForChromeBrowser(capabilities);

        return capabilities;
    }

    private static DesiredCapabilities getCapabilitiesForCalculator(DesiredCapabilities capabilities){
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        return capabilities;
    }

    private static DesiredCapabilities getCapabilitiesForChromeBrowser(DesiredCapabilities capabilities){
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        return capabilities;
    }

    private static DesiredCapabilities getCapabilitiesForYouTube(DesiredCapabilities capabilities){
        capabilities.setCapability("appPackage", "com.google.android.youtube");
//        capabilities.setCapability("appActivity", ".app.honeycomb.Shell$HomeActivity");
        capabilities.setCapability("appActivity", "com.google.android.apps.youtube.app.WatchWhileActivity");
        return capabilities;
    }

    public static void closeDriver() {
        try {
            appiumDriver.closeApp();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}