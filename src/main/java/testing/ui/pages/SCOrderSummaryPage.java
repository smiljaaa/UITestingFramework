package testing.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SCOrderSummaryPage extends BasePage {

    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    public WebElement orderConfirmationButton;

    public SCOrderSummaryPage(WebDriver driver){
        super(driver);
    }

    public boolean isAt(){
        return super.isAt(orderConfirmationButton);
    }

    public SCOrderConfirmationPage clickOnOrderConfirmationButton(){
        clickOnElement(orderConfirmationButton);
        return PageFactory.initElements(driver, SCOrderConfirmationPage.class);

    }
}
