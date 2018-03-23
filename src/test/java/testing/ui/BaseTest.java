package testing.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import testing.ui.pages.BasePage;
import testing.ui.pages.HomePage;
import testing.ui.pages.LogInPage;
import testing.ui.pages.ProductDetailsPage;
import testing.ui.utils.Constants;

import java.io.IOException;

public class BaseTest {

    protected static Logger log = LogManager.getLogger(BaseTest.class.getName());
    protected static WebDriver driver;
    protected static String username, password;


    public WebDriver startWebDriver(){
        if(driver==null)
            driver =  new FirefoxDriver();
        driver.get(Constants.URL);
        driver.manage().window().maximize();
        return driver;
    }

    @AfterSuite(alwaysRun=true)
    public void afterSuite(){
        this.closeWebDriver();
    }

    public HomePage getHomePage(){
        driver = startWebDriver();
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertTrue(homePage.isAt());
        return homePage;
    }

    protected BasePage loginToHomePage() {
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        if(!basePage.isLoggedIn()) {
            LogInPage loginPage = basePage.clickOnSignInButton();
            basePage = loginPage.login(Constants.username, Constants.password, BasePage.class);
            Assert.assertTrue(basePage.isLoggedIn(), "User is logged in");
        }
        return basePage;
    }

    protected void closeWebDriver() {
        if(driver != null)
            driver.quit();
    }
}
