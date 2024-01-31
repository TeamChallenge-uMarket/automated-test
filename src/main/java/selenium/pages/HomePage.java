package selenium.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebElement;
import static selenium.DriverWaiter.*;

public class HomePage {
    private final WebDriver driver;
    private final By LOGIN_BUTTON = By.xpath("//a/span");
    private final By EMAIL_INPUT = By.xpath("//input[@type='email']");
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        logger.info("Get title");
        return driver.getTitle();
    }

    public void clickOnLoginButton() {
        logger.info("Click on login button");
        WebElement loginButton = driver.findElement(LOGIN_BUTTON);
        waitForElementToBeClickable(loginButton);
        loginButton.click();
    }

    public String getInputPlaceholderValue() {
        logger.info("Get input placeholder value");
        return driver.findElement(EMAIL_INPUT).getAttribute("placeholder");
    }

}