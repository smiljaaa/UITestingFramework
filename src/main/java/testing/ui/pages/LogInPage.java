package testing.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage {

    @FindBy(id = "email_create")
    WebElement createEmailInput;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "passwd")
    WebElement passInput;

    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    @FindBy(id = "SubmitCreate")
    WebElement createAnAccountButton;


    public LogInPage(WebDriver driver) {

        super(driver);
    }

    public boolean isAt(){

        return super.isAt(createEmailInput);
    }

    public CreateAccountPage clickOnCreateNewAccountButton() {
        clickOnElement(createAnAccountButton);
        return PageFactory.initElements(driver, CreateAccountPage.class);
    }

    public void setNewUserEmail(String email){
        setElementText(createEmailInput,email);
    }

    public BasePage login(String userName, String pass){
        return this.login(userName, pass, BasePage.class);
    }

    public <T extends BasePage> T login(String userName, String pass, Class<T> p) {
        setElementText(emailInput,userName);
        setElementText(passInput,pass);
        clickOnElement(signInButton);
        return PageFactory.initElements(driver, p);
    }

}




