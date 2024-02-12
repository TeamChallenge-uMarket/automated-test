package selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static selenium.DriverWaiter.*;

public class LoginPage {
    private final WebDriver driver;
    private final By SIGN_UP_BUTTON = By.xpath("//a[@href='/login/sign-up']");
    private final By LOGIN_BUTTON = By.xpath("//a/span");
    private final By FULL_NAME_INPUT = By.cssSelector(".SignUpPage_Login_field__fmEqx");
    private final By EMAIL_INPUT = By.id("email");
    private final By PASSWORD_INPUT = By.id("password");
    private final By CONFIRM_PASSWORD = By.id("confirmPassword");
    private final By SUBMIT_REGISTRATION = By.cssSelector(".SignUpPage_Login_btn__uWEVQ");
    private final By INBOX_LIST = By.className("row-link");
    private final By LINK_TO_VERIFY = By.xpath("//a[@target='_blank']");
    private final By LOGIN_BANNER = By.xpath("//h2[@class='LoginPage_Login_title__NlylK']");
    private final By LOGIN_EMAIL_INPUT = By.xpath("//input[@type='email']");
    private final By LOGIN_PASSWORD_INPUT = By.xpath("//input[@type='password']");
    private final By SUBMIT_LOGIN = By.xpath("//button[@type='submit']");

    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    public void openURL (String url) {
        driver.get(url);
    }

    public void clickOnLoginButton() {
        logger.info("Click on login button");
        WebElement loginButton = driver.findElement(LOGIN_BUTTON);
        waitForElementToBeClickable(loginButton);
        loginButton.click();
    }

    public void clickOnSignUpButton() {
        logger.info("Click on sign up button");
        WebElement signUp = driver.findElement(SIGN_UP_BUTTON);
        waitForElementToBeClickable(signUp);
        signUp.click();
    }

    public void submitNameAndEmail(String fullName, String email) {
        logger.info("Create user");
        driver.findElement(FULL_NAME_INPUT).sendKeys(fullName);
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    public void submitPassword(String password) {
        WebElement passwordInput = driver.findElement(PASSWORD_INPUT);
        waitForElementToBeClickable(passwordInput);
        passwordInput.sendKeys(password);
        driver.findElement(CONFIRM_PASSWORD).sendKeys(password);
    }

    public void submitRegistration() {
        driver.findElement(SUBMIT_REGISTRATION).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void openNewTab() {
        logger.info("Open new tab");
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public void switchToWindowHandleAtIndex(int index, String additionalInfo) {
        logger.info("Switch to window handle at index: " + index + " : " + additionalInfo);
        Set<String> windowHandles = driver.getWindowHandles();
        driver.switchTo().window((String) windowHandles.toArray()[index]);
    }

    public void findEmailAtInboxAndVerify() {
        List<WebElement> inboxList = driver.findElements(INBOX_LIST);
        WebElement neededElementInbox = inboxList.get(0);
        WebElement verifyLink = driver.findElement(LINK_TO_VERIFY);
        for (WebElement element : inboxList) {
            if (element.getText().equals("Verify account")) {
                neededElementInbox = element;
            }
        }
        waitForElementToBeClickable(neededElementInbox);
        neededElementInbox.click();
        waitForElementToBeClickable(verifyLink);
        verifyLink.click();
    }

    public String getAttributeValue(String attributeName) {
        return driver.findElement(LOGIN_BANNER).getAttribute(attributeName);
    }

    public void loginUser(String email, String password) {
        driver.findElement(LOGIN_EMAIL_INPUT).sendKeys(email);
        driver.findElement(LOGIN_PASSWORD_INPUT).sendKeys(password);
    }

    public void submitLogin() {
        driver.findElement(SUBMIT_LOGIN).click();
    }
}