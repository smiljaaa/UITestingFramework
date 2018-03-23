package testing.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage {


    @FindBy(id = "id_gender1")
    public WebElement mrRadioButton;

    @FindBy(id = "id_gender2")
    public WebElement mrsRadioButton;

    @FindBy(id = "customer_firstname")
    public WebElement customerFirstNameInput;

    @FindBy(id = "customer_lastname")
    public WebElement customerLastNameInput;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "passwd")
    public WebElement passInput;

    @FindBy(id = "days")
    public WebElement daysDropdownMenu;

    @FindBy(id = "months")
    public WebElement monthDropdownsMenu;

    @FindBy(id = "years")
    public WebElement yearsDropdownMenu;

    @FindBy(id = "newsletter")
    public WebElement newsletterCheckBox;

    @FindBy(id = "optin")
    public WebElement specialOfferCheckBox;

    @FindBy(id = "firstname")
    public WebElement firstNameInput;

    @FindBy(id = "lastname")
    public WebElement lastNameInput;

    @FindBy(id = "address1")
    public WebElement address1Input;

    @FindBy(id = "city")
    public WebElement cityInput;

    @FindBy(id = "id_state")
    public WebElement dropdownStateMenu;

    @FindBy(id = "id_country")
    public WebElement dropdownContryMenu;

    @FindBy(id = "postcode")
    public WebElement postcodeInput;

    @FindBy(id = "phone_mobile")
    public WebElement mobilePhoneInput;

    @FindBy(id = "addressAlias")
    public WebElement addressAliasInput;

    @FindBy(id = "submitAccount")
    public WebElement registerButton;

    public CreateAccountPage(WebDriver driver) {

        super(driver);
    }

    public boolean isAt() {

        return super.isAt(mrRadioButton);
    }



    public void setFirstName(String name) {
        setElementText(customerFirstNameInput,name);
    }

    public void setLastName(String lastName) {
        setElementText(customerLastNameInput,lastName);
    }

    public void setEmail(String email) {
        setElementText(emailInput,email);
    }

    public void setPass(String pass) {
        setElementText(passInput,pass);
    }

    public void setFirstName1(String firstName1) {
        setElementText(firstNameInput,firstName1);
    }

    public void setLastName1(String lastName1) {
        setElementText(lastNameInput,lastName1);
    }

    public void setAddress(String address) {
        setElementText(address1Input,address);
    }

    public void setCity(String city) {
        setElementText(cityInput,city);
    }

    public void selectStateMenu(String state) {
        Select dropdownState = new Select(dropdownStateMenu);
        dropdownState.selectByVisibleText(state);
    }

    public void selectDayMenu(String day){
        selectDropdownValue(daysDropdownMenu,day);
    }

    public void selectMonthMenu(String month){
        selectDropdownValue(monthDropdownsMenu, month);
    }

    public void selectYearMenu(String year){
        selectDropdownValue(yearsDropdownMenu, year);
    }

    public void selectCountryMenu(String country){
        Select dropdownCountry = new Select(dropdownContryMenu);
        dropdownCountry.selectByVisibleText(country);
    }

    public void setZip(String zip) {
        setElementText(postcodeInput,zip);
    }

    public void setMobilePhone(String mobilePhone) {
        setElementText(mobilePhoneInput,mobilePhone);
    }

    public void setNewUserData(String customerFirstName, String customerLastName, String pass, String day, String month, String year,
                                String firstName, String lastName, String address, String city, String state,  String zip, String country, String mobilePhone) {

        mrRadioButton.click();

        setFirstName(customerFirstName);
        setLastName(customerLastName);
        setPass(pass);

        selectDayMenu(day);
        selectMonthMenu(month);
        selectYearMenu(year);

        setFirstName1(firstName);
        setLastName1(lastName);
        setAddress(address);
        setCity(city);

        selectStateMenu(state);

        setZip(zip);

        selectCountryMenu(country);

        setMobilePhone(mobilePhone);
    }

    public MyAccountPage clickOnRegisterButton() {
        clickOnElement(registerButton);
        return PageFactory.initElements(driver, MyAccountPage.class);
    }
}




