package Utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class driverManager {
    public static AppiumDriver appiumDriver;

    public static void openDriver() throws Exception {

        appiumDriver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), getCapabilities());
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private static DesiredCapabilities getCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.15.1");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "10");

        return capabilities;
    }

    public static void closeDriver()
    {
        appiumDriver.close();
    }
}
