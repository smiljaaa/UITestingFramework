package testing.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsPage extends BasePage{

    List<String> productsAddedToTheCartList = new ArrayList<>();
    String uniqueProductIDString;

    @FindBy(id = "add_to_cart")
    WebElement addToCardButtonPDP;

    @FindBy(xpath = "//a[@class='btn btn-default button button-medium']")
    WebElement proceedToCheckOutButton;

    @FindBy(xpath = "//span[@class='continue btn btn-default button exclusive-medium']")
    WebElement continueShoppingButton;

    @FindBy(xpath = " //div[@class='shopping_cart']")
    WebElement shoppingCart;

    @FindBy(xpath = "//span[@itemprop='sku']")
    WebElement uniqueProductIdentifier;


    public ProductDetailsPage (WebDriver driver) {

        super(driver);
    }

    public boolean isAt(){

        return super.isAt(addToCardButtonPDP);
    }

    public WebElement getUniqueProductIdentifier() {

        return uniqueProductIdentifier;
    }

    public ProductDetailsPage clickOnContinueShoppingButton(){
        clickOnElement(continueShoppingButton);
        return PageFactory.initElements(driver, ProductDetailsPage.class);
    }

    public ProductDetailsPage clickOnAddToCardButtonPDP(){
        clickOnElement(addToCardButtonPDP);
        return PageFactory.initElements(driver, ProductDetailsPage.class);
    }

    public SCSummaryPage clickOnProceedToCheckOutButton(){
        clickOnElement(proceedToCheckOutButton);
        return PageFactory.initElements(driver, SCSummaryPage.class);
    }

}
