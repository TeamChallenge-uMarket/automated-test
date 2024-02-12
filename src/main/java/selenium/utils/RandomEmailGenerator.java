package selenium.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static selenium.DriverWaiter.*;

public class RandomEmailGenerator {

    private final WebDriver driver;
    private static final String urlToEmailService = "https://10minutemail.net";
    private static final Logger logger = LogManager.getLogger(RandomEmailGenerator.class);

    By MAIL_TEXT = By.xpath("//input[@class='mailtext']");

    public RandomEmailGenerator(WebDriver driver) {
        this.driver = driver;
    }

    public void openService() {
        logger.info("Open URL: " + urlToEmailService);
        driver.get(urlToEmailService);
    }

    public String getTemporaryEmailValue() {
        logger.info("Get temporary email value");
        waitForElementToBeVisible(driver.findElement(MAIL_TEXT));
        return driver.findElement(MAIL_TEXT).getAttribute("value");
    }
}
