package testing.ui;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testing.ui.pages.*;
import testing.ui.utils.Constants;

public class CheckOutTest extends BaseTest {

    HomePage homePage;
    LogInPage logInPage;
    MyAccountPage myAccountPage;
    ProductDetailsPage productDetailsPage;
    SCSummaryPage scSummaryPage;
    SCAddressPage scAddressPage;
    SCShippingPage scShippingPage;
    SCPaymentPage scPaymentPage;
    SCOrderSummaryPage scOrderSummaryPage;
    SCOrderConfirmationPage scOrderConfirmationPage;

    @BeforeClass
    public void setUp() throws Exception {

        homePage = getHomePage();

    }

    @Test
    public void checkOutTest(){

        logInPage = homePage.clickOnSignInButton();
        Assert.assertTrue(logInPage.isAt());

        myAccountPage = logInPage.login(Constants.username,Constants.password, MyAccountPage.class);
        Assert.assertTrue(myAccountPage.isLoggedIn());
        Assert.assertTrue(myAccountPage.isAt());

        homePage = myAccountPage.clickOnHeaderLogo();
        Assert.assertTrue(homePage.isAt());

        productDetailsPage = homePage.clickOnProduct(Constants.productIndex1);
        Assert.assertTrue(productDetailsPage.isAt());

        productDetailsPage = productDetailsPage.clickOnAddToCardButtonPDP();
        Assert.assertTrue(productDetailsPage.isAt());

        scSummaryPage = productDetailsPage.clickOnProceedToCheckOutButton();
        Assert.assertTrue(scSummaryPage.isAt());

        scAddressPage = scSummaryPage.clickOnProceedToCheckOutButton();
        Assert.assertTrue(scAddressPage.isAt());

        scShippingPage = scAddressPage.clickOnProceedToCheckOutButton();
        Assert.assertTrue(scShippingPage.isAt());

        scShippingPage = scShippingPage.clickOnCheckBoxTermsOfService();
        Assert.assertTrue(scShippingPage.isAt());

        scPaymentPage = scShippingPage.clickOnProceedToCheckOutButton();
        Assert.assertTrue(scPaymentPage.isAt());

        scOrderSummaryPage = scPaymentPage.clickOnPayByBankWire();
        Assert.assertTrue(scOrderSummaryPage.isAt());

        scOrderConfirmationPage = scOrderSummaryPage.clickOnOrderConfirmationButton();
        Assert.assertTrue(scOrderConfirmationPage.isAt());
        Assert.assertEquals(scOrderConfirmationPage.getOrderMessageText(),Constants.orderMessageText);

    }


}
