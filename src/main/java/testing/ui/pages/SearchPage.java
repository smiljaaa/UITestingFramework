package testing.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//ul[@class='product_list grid row']")
    WebElement searchedProducts;

    List<WebElement> searchedProductsList;

    public List<WebElement> getSearchedProductsList(){
        searchedProductsList = searchedProducts.findElements(By.tagName("li"));
        return searchedProductsList;
    }

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    WebElement searchWarningMessage;

    public SearchPage(WebDriver driver) {

        super(driver);
    }

    public boolean isAt() {

        return super.isAt(searchedProducts);
    }

    public WebElement getSearchWarningMessage(){

        return searchWarningMessage;
    }

    public String getSearchedProductTitle(int i, WebDriver driver){
        String s = searchedProductsList.get(i).getAttribute("title");
        return s;
    }

    public ProductDetailsPage clickOnSearchedProduct(int i){
        clickOnElement(getSearchedProductsList().get(i));
        return PageFactory.initElements(driver, ProductDetailsPage.class);
    }

}
