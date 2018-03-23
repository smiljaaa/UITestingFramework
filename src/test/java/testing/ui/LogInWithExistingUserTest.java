package testing.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import testing.ui.pages.*;
import testing.ui.utils.Constants;

import java.util.concurrent.TimeUnit;


public class LogInWithExistingUserTest extends BaseTest {

    HomePage homePage;
    LogInPage logInPage;
    MyAccountPage myAccountPage;

    @BeforeClass(alwaysRun = true)

    public void setUp() {

        homePage = getHomePage();
    }

    @DataProvider(name = "existingUser")

    public Object[][] existingUser() {
        return new Object[][] { {"testera2@testera.com", "Testera123!@#"} };

    }

    @Test(dataProvider = "existingUser")
    public void testLogInWithExistingUser(String userName, String pass) {

        logInPage = homePage.clickOnSignInButton();
        Assert.assertTrue(logInPage.isAt());

        myAccountPage = logInPage.login(userName,pass,MyAccountPage.class);
        Assert.assertTrue(myAccountPage.isLoggedIn());
        Assert.assertTrue(myAccountPage.isAt());
    }

    @Test (dependsOnMethods = "testLogInWithExistingUser")

    public void testLogOutWithExistingUser(){
        logInPage = myAccountPage.clickOnSignOutButton();
        Assert.assertTrue(logInPage.isAt());
    }
}



