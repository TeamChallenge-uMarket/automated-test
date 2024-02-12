package org.uAuto;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.DriverProvider;

public class BaseTest {
    @BeforeMethod
    public void openBrowser() {
        // Opens a new browser instance
        WebDriver driver = DriverProvider.getInstance();
        driver.get("https://pawo.space/");
    }

    @AfterMethod
    public void closeBrowser() {
        // Closes a browser instance
        DriverProvider.quit();
    }
}
