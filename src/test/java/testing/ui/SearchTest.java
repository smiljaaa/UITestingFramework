package testing.ui;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testing.ui.pages.*;
import testing.ui.utils.Constants;

import static testing.ui.utils.Constants.emptySearchMessage;
import static testing.ui.utils.Constants.randomSearchWarnMessage;


public class SearchTest extends BaseTest{

    HomePage homePage;
    SearchPage searchPage;



    @BeforeClass
    public void setUp() throws Exception {

        homePage = getHomePage();

    }

    @Test
    public void testValidSearch(){
        searchPage = homePage.performSearch(Constants.searchBlouse);
        Assert.assertEquals(searchPage.getSearchedProductsList().get(Constants.productIndex0).getText().contains("Blouse"),true);
    }

    @Test
    public void testWrongSearch(){
        searchPage=homePage.performSearch(Constants.randomAlphaChars);
        Assert.assertEquals(searchPage.getSearchWarningMessage().getText(), randomSearchWarnMessage + Constants.randomAlphaCharsVer);
    }

    @Test
    public void testEmptySearch(){
        searchPage=homePage.performSearch("");
        Assert.assertEquals(searchPage.getSearchWarningMessage().getText(), emptySearchMessage);
    }
}
