package testing.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "homefeatured")
    WebElement products;

    List<WebElement> productsList;

    public List<WebElement> getProductsList() {
        productsList = products.findElements(By.tagName("li"));
        return productsList;
    }

    public HomePage(WebDriver driver) {

        super(driver);
    }

    public boolean isAt() {

        return super.isAt(products);
    }

    public ProductDetailsPage clickOnProduct(int i) {
        clickOnElement(getProductsList().get(i));
        return PageFactory.initElements(driver, ProductDetailsPage.class);
    }
}




