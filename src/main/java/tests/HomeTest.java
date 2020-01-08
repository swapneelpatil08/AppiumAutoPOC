package tests;
import Utils.driverManager;
import org.testng.annotations.Test;

public class HomeTest {

    @Test
    public void OpenDriver() throws Exception {
        driverManager.openDriver();
        driverManager.closeDriver();
    }

}
