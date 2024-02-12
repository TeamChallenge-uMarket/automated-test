package org.uAuto;

import org.testng.annotations.Test;
import selenium.pages.HomePage;
import selenium.DriverProvider;
import static org.testng.Assert.assertEquals;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageTitleMatches() {
        HomePage page = new HomePage(DriverProvider.getInstance());

        String expected = "Product catalog";
        String actual = page.getTitle();

        assertEquals(actual, expected);
    }

    @Test
    public void switchesToLoginWindow() {
        HomePage page = new HomePage(DriverProvider.getInstance());
        page.clickOnLoginButton();
        String expected = "E-mail";
        String actual = page.getInputPlaceholderValue();
        assertEquals(actual, expected);
    }
}
