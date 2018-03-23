package testing.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SCAddressPage extends BasePage {

    @FindBy(xpath = "//button[@name='processAddress']")
    WebElement proceedToCheckOutButton;

    public SCAddressPage (WebDriver driver){

        super(driver);
    }

    public boolean isAt(){

        return super.isAt(proceedToCheckOutButton);
    }

    public SCShippingPage clickOnProceedToCheckOutButton(){
        clickOnElement(proceedToCheckOutButton);
        return PageFactory.initElements(driver, SCShippingPage.class);
    }
}
