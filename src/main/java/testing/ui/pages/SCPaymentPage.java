package testing.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SCPaymentPage extends BasePage{

    @FindBy(xpath = "//a[@class='bankwire']")
    public WebElement payByBankWire;

    public SCPaymentPage (WebDriver driver){

        super(driver);
    }

    public boolean isAt(){

        return super.isAt(payByBankWire);
    }

    public SCOrderSummaryPage clickOnPayByBankWire(){
        payByBankWire.click();
        return PageFactory.initElements(driver, SCOrderSummaryPage.class);


    }


}
