package org.uAuto;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import selenium.DriverProvider;
import selenium.pages.LoginPage;
import selenium.utils.RandomEmailGenerator;

import static org.testng.AssertJUnit.assertEquals;

public class RegistrationTest extends BaseTest {
    // Saving user information
    User user = new User("Test User","qwerty123uAuto~");

    @Test
    public void allowsRegisterUser() {
        WebDriver driver = DriverProvider.getInstance();
        LoginPage page = new LoginPage(driver);
        RandomEmailGenerator generator = new RandomEmailGenerator(DriverProvider.getInstance());

        // Using temporary email service for registration
        page.openNewTab();
        page.switchToWindowHandleAtIndex(1,"Switches to new tab");
        generator.openService();
        user.setEmail(generator.getTemporaryEmailValue());
        page.switchToWindowHandleAtIndex(0,"Switches to original tab");

        page.clickOnLoginButton();
        page.clickOnSignUpButton();
        page.submitNameAndEmail(user.getName(), user.getEmail());
        page.submitPassword(user.getPassword());
        page.submitRegistration();
        page.switchToWindowHandleAtIndex(1, "Email tab");
        page.findEmailAtInboxAndVerify();

        String expected = "LoginPage_Login_title__NlylK";
        String actual = page.getAttributeValue("class");

        assertEquals(expected,actual);
        }

        @Test(dependsOnMethods = {"allowsRegisterUser"})
        public void allowsLoginUser() {
            WebDriver driver = DriverProvider.getInstance();
            LoginPage page = new LoginPage(driver);
            page.openURL("https://pawo.space/login/log-in");
            page.loginUser(user.getEmail(), user.getPassword());
            page.submitLogin();
        }
}