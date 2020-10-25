package pageObjects;

import gherkin.lexer.Ja;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Header {

    public WebDriver driver;

    public Header(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Actions
    //JavaScriptExecutor
    //Robot

    @FindBy(id="header-logo")
    public WebElement logoText;

    @FindBy(name="w")
    public WebElement searchTxtFld;

    @FindBy(xpath="//*[@id=\"newsearch\"]/input[4]")
    public WebElement searchIcon;

    @FindBy(id="header-logo")
    public WebElement myAccountLink;

    @FindBy(id="header-logo")
    public  WebElement helpLink;

    @FindBy(id="header-logo")
    public WebElement storeLocatorLink;

    @FindBy(id="header-logo")
    public WebElement quickShopLink;

    @FindBy(id="header-logo")
    public WebElement wishListIcon;

    @FindBy(id="header-logo")
    public WebElement basketIcon;

    @FindBy(id="header-logo")
    public WebElement menuOption;

    @FindBy(id="header-logo")
    public WebElement subMenuOption;


    public void verifyLogo()
    {
        Assert.assertTrue(logoText.isDisplayed());
    }

    public void enterSearchTerm(String searchTerm)
    {
        searchTxtFld.sendKeys(searchTerm);
    }

    public void clickSearchIcon() throws Exception
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(searchIcon).click().build().perform();

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", searchIcon);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    public void clickMyAccount()
    {
        myAccountLink.click();
    }
}
