package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {

    public ProductListPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id="")
    public WebElement productList;


    public void validateProductResults()
    {
        Assert.assertTrue(productList.isDisplayed());
    }

}
