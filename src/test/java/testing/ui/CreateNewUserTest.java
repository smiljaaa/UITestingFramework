package testing.ui;

import org.testng.Assert;
import org.testng.annotations.*;

import testing.ui.pages.CreateAccountPage;
import testing.ui.utils.Randomizer;
import testing.ui.pages.HomePage;
import testing.ui.pages.LogInPage;
import testing.ui.pages.MyAccountPage;


public class CreateNewUserTest extends BaseTest{

    HomePage homePage;
    LogInPage logInPage;
    CreateAccountPage createAccountPage;
    MyAccountPage myAccountPage;

    @BeforeClass
    public void setUp() throws Exception {

        homePage = getHomePage();

    }

    @DataProvider(name = "NewUser")

    public Object[][] newUser() {

        return new Object[][] { { "testera", "testeric", "Testera123!@#", "1", "12", "1981", "testera", "testeric",
                "testerina ulca 1", "Bukoloram", "Alabama",  "18000", "United States", "00123456789"}};
    }
    @Test(dataProvider = "NewUser")

    public void testAddNewUSer(String customerFirstName, String customerLastName, String pass, String day, String month, String year,
                               String firstName, String lastName, String address, String city, String state,  String zip, String country, String mobilePhone) {

        logInPage = homePage.clickOnSignInButton();
        Assert.assertTrue(logInPage.isAt());

        String newUserEmail = Randomizer.getRandomEmailAddress();
        log.info(newUserEmail + "mail adresa");

        logInPage.setNewUserEmail(newUserEmail);
        createAccountPage = logInPage.clickOnCreateNewAccountButton();
        createAccountPage.waitForElementToBeVisible(driver, createAccountPage.mrRadioButton);
        Assert.assertTrue(createAccountPage.isAt());

        createAccountPage.setNewUserData(customerFirstName, customerLastName, pass, day, month, year,
                firstName, lastName, address, city, state,  zip, country, mobilePhone);

        myAccountPage = createAccountPage.clickOnRegisterButton();
        Assert.assertTrue(myAccountPage.isAt());

        logInPage = myAccountPage.clickOnSignOutButton();
        Assert.assertTrue(logInPage.isAt());

        }

    }


