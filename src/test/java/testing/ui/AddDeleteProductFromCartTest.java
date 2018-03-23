package testing.ui;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testing.ui.pages.*;
import testing.ui.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class AddDeleteProductFromCartTest extends BaseTest{

    HomePage homePage;
    ProductDetailsPage productDetailsPage;
    SCSummaryPage scSummaryPage;

    @BeforeClass
    public void setUp() throws Exception {

        homePage = getHomePage();

    }

    @Test
    public void AddProductsToTheCart() {

        List<String> productsAddedToTheCartList = new ArrayList<>();
        String productUniqueIdentifier;

        productDetailsPage = homePage.clickOnProduct(Constants.productIndex0);
        Assert.assertTrue(productDetailsPage.isAt());

        productDetailsPage = productDetailsPage.clickOnAddToCardButtonPDP();
        Assert.assertTrue(productDetailsPage.isAt());

        productUniqueIdentifier = productDetailsPage.getUniqueProductIdentifier().getText();
        productsAddedToTheCartList.add(productUniqueIdentifier);

        productDetailsPage = productDetailsPage.clickOnContinueShoppingButton();
        Assert.assertTrue(productDetailsPage.isAt());

        homePage = productDetailsPage.clickOnHeaderLogo();
        Assert.assertTrue(homePage.isAt());

        productDetailsPage = homePage.clickOnProduct(Constants.productIndex1);
        Assert.assertTrue(productDetailsPage.isAt());

        productDetailsPage = productDetailsPage.clickOnAddToCardButtonPDP();
        Assert.assertTrue(productDetailsPage.isAt());

        productUniqueIdentifier = productDetailsPage.getUniqueProductIdentifier().getText();
        productsAddedToTheCartList.add(productUniqueIdentifier);


        scSummaryPage = productDetailsPage.clickOnProceedToCheckOutButton();
        Assert.assertTrue(scSummaryPage.isAt());

        log.info("These products were added to cart - product id: " + productsAddedToTheCartList);
        log.info("Number of products added to the cart and number of products on shopping cart summary page should be the same!");

        if(productsAddedToTheCartList.size() == scSummaryPage.getProductDescriptionList().size()){
            for(int i = 0; i < productsAddedToTheCartList.size(); i++){
                if(scSummaryPage.getProductDescriptionList().get(i).contains(productsAddedToTheCartList.get(i))){
                    log.info("Cart summary contains proper products. Product id is:  " + productsAddedToTheCartList.get(i));
                }
            }
        }else{
           log.info("Number of products added to cart and number of products in the cart summary is not the same!");
        }
    }

    @Test(dependsOnMethods = "AddProductsToTheCart")

    public void deleteProductsFromTheCart(){
        scSummaryPage = scSummaryPage.deleteAllProducts(driver);
        scSummaryPage.waitForElementToBeVisible(driver, scSummaryPage.getShoppingCartIsEmptyMessage());
        Assert.assertEquals(scSummaryPage.getShoppingCartIsEmptyMessage().getText(),Constants.emptyShoppingCartMessage);
    }
}

