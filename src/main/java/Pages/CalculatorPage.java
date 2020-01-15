package Pages;

import Utils.driverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage extends driverManager {

    private AndroidDriver<MobileElement> driver;

    public CalculatorPage() throws Exception {
        this.driver = driverManager.openDriver(driverManager.appToBeOpened.Calculator);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(accessibility = "plus")
    private AndroidElement plus;

    @AndroidFindBy(accessibility = "equals")
    private AndroidElement equals;

    @AndroidFindBy(id = "result")
    private AndroidElement result;

    public String Addition(int number1, int number2) {
        ClickNumber(number1);
        plus.click();
        ClickNumber(number2);
        equals.click();
        String addition = result.getText();
        System.out.println(addition);
        return addition;
    }

    public void ClickNumber(int number) {
        String id = "digit_" + number;
        driver.findElementById(id).click();
    }
}
