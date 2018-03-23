package testing.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SCShippingPage extends BasePage {

    @FindBy(xpath = "//button[@name='processCarrier']")
    public WebElement proceedToCheckOutButton;

    @FindBy(xpath = "//span/input[@id='cgv']")
    public WebElement checkBoxTermsOfService;

    public SCShippingPage (WebDriver driver){

        super(driver);
    }

    public boolean isAt(){

        return super.isAt(proceedToCheckOutButton);
    }

    public SCShippingPage clickOnCheckBoxTermsOfService(){
        checkBoxTermsOfService.click();
        return PageFactory.initElements(driver, SCShippingPage.class);
    }

    public SCPaymentPage clickOnProceedToCheckOutButton(){
        clickOnElement(proceedToCheckOutButton);
        return PageFactory.initElements(driver, SCPaymentPage.class);
    }




}
