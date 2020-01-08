package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class driverManager {
    public static AppiumDriver<MobileElement> appiumDriver;

    public static void openDriver() throws Exception {

        appiumDriver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), getCapabilities());
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private static DesiredCapabilities getCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.9.1");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "Andriod SDK built for x86");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("UDID", "emulator-5554");
        capabilities.setCapability("browserName", "Chrome");

        return capabilities;
    }

    public static void closeDriver()
    {
        appiumDriver.close();
    }
}
