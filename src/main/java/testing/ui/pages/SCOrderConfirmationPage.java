package testing.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SCOrderConfirmationPage extends BasePage{

    @FindBy(xpath = "//p[@class='cheque-indent']/strong[@class='dark']")
    WebElement orderMessage;

    @FindBy(xpath = "//p[@class='cart_navigation exclusive']")
    WebElement backToOrdersNavigation;

    public SCOrderConfirmationPage(WebDriver driver){
        super(driver);
    }

    public boolean isAt(){

        return super.isAt(backToOrdersNavigation);
    }

    public String getOrderMessageText(){

        return orderMessage.getText();
    }
}
