package testing.ui.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePage {

    protected WebDriver driver;
    public static int IMPLICIT_WAIT = 5;


    @FindBy(id = "header_logo")
    WebElement headerLogo;

    @FindBy(id = "search_query_top")
    WebElement searchBox;

    @FindBy(xpath = "//*[@class='btn btn-default button-search']")
    WebElement searchButton;

    @FindBy(xpath = "//*[@class='login']")
    WebElement signInButton;

    @FindBy(xpath = "//*[@class='logout']")
    WebElement signOutButton;


    public BasePage(WebDriver driver) {


        this.driver = driver;
    }

    public boolean isAt(WebElement uniquePageElement){
        try {
            return uniquePageElement.isDisplayed();
        } catch (NoSuchElementException ne) {
            return false;
        }
    }

    public static WebElement waitForElementToBeClickable(WebDriver webDriver, WebElement element){
        return (new WebDriverWait(webDriver, IMPLICIT_WAIT)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement element){
        return (new WebDriverWait(driver, IMPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
    }


    public void clickOnElement(WebElement element){
        WebElement clickableElement = waitForElementToBeClickable(driver, element);
        if (clickableElement != null)
            clickableElement.click();
    }

    public void setElementText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"),text);
    }

    public void selectDropdownValue(WebElement dropdownMenu, String value){
        Select select = new Select(dropdownMenu);
        select.selectByValue(value);
    }


    public SearchPage performSearch(String s){
        setElementText(searchBox,s);
        clickOnElement(searchButton);
        return PageFactory.initElements(driver, SearchPage.class);
    }


    public HomePage clickOnHeaderLogo(){
        clickOnElement(headerLogo);
        headerLogo.click();
        return PageFactory.initElements(driver, HomePage.class);
    }

    public boolean isLoggedIn(){
        return isAt(signOutButton);
    }

    public BasePage logout() {
        clickOnElement(signOutButton);
        return PageFactory.initElements(driver, BasePage.class);
    }

    public LogInPage clickOnSignInButton() {
        clickOnElement(signInButton);
        return PageFactory.initElements(driver, LogInPage.class);
    }

}
