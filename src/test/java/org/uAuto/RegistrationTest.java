package org.uAuto;
import org.testng.annotations.Test;
import selenium.DriverProvider;
import selenium.pages.LoginPage;
import selenium.utils.RandomEmailGenerator;

public class RegistrationTest extends BaseTest {

    @Test
    public void allowsRegisterUser() {
        LoginPage loginPage = new LoginPage(DriverProvider.getInstance());
        RandomEmailGenerator generator = new RandomEmailGenerator(DriverProvider.getInstance());
        // coming soon
    }
}
