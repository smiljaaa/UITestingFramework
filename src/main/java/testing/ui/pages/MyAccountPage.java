package testing.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage{

    @FindBy(xpath = "//i[@class='icon-user']")
    WebElement myPersonalInfoIcon;


    public MyAccountPage (WebDriver driver){

        super(driver);
    }

    public boolean isAt(){

        return super.isAt(myPersonalInfoIcon);
    }

    public LogInPage clickOnSignOutButton() {
        clickOnElement(signOutButton);
        return PageFactory.initElements(driver, LogInPage.class);
    }


}



