package testing.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testing.ui.utils.Constants;
import java.util.ArrayList;
import java.util.List;

public class SCSummaryPage extends BasePage {

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    WebElement proceedToCheckOutButton;

    @FindBy(xpath = "//td[@data-title='Delete']")
    WebElement deleteButton;

    @FindBy (id = "cart_summary")
    WebElement cartSummaryTable;

    List<WebElement> cartSummaryTableRows;

    public List<WebElement> getSCartSummaryTableRows(){
        cartSummaryTableRows = cartSummaryTable.findElements(By.xpath("//table[@id='cart_summary']/tbody/tr"));
        return cartSummaryTableRows;
    }

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    WebElement shoppingCartIsEmptyMessage;

    public SCSummaryPage(WebDriver driver) {

        super(driver);
    }

    public boolean isAt() {

        return super.isAt(proceedToCheckOutButton);
    }

    public WebElement getShoppingCartIsEmptyMessage(){

        return shoppingCartIsEmptyMessage;
    }

    public void deleteSingleProduct(){
        for(WebElement trElement : getSCartSummaryTableRows()) {
            if (deleteButton.isDisplayed()) {
                deleteButton.click();
            }
        }
    }

    public List<String> getProductDescriptionList(){
        List<String> list = new ArrayList<>();

        for(WebElement trElement : getSCartSummaryTableRows()){
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            list.add(td_collection.get(Constants.descriptionColumnIndex).getText());
        }
        return list;
    }

    public SCSummaryPage deleteAllProducts(WebDriver driver){

        for(WebElement trElement : getSCartSummaryTableRows()){
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            if (deleteButton.isDisplayed()){
                td_collection.get(Constants.deleteColumnIndex).click();
            }
        }
        return PageFactory.initElements(driver, SCSummaryPage.class);
    }

    public SCAddressPage clickOnProceedToCheckOutButton(){
        clickOnElement(proceedToCheckOutButton);
        return PageFactory.initElements(driver, SCAddressPage.class);
    }
}
