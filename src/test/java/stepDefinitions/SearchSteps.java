package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functionLibrary.CommonFunctions;
import pageObjects.BasketPage;
import pageObjects.Header;
import pageObjects.ProductListPage;

public class SearchSteps extends CommonFunctions {

    Header header = new Header(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    BasketPage basketPage = new BasketPage(driver);


    @Given("^I'm on homepage$")
    public void i_m_on_homepage() throws Exception {
       driver.get(getDataFrmPrprty("url"));
    }

    @When("^I enter searchTerm \"([^\"]*)\"$")
    public void i_enter_searchTerm(String searchTerm)  {
        implicitwait(5);
        explicitWait(header.searchTxtFld, 10);
        header.enterSearchTerm(searchTerm);
    }

    @When("^I click searchIcon$")
    public void i_click_searchIcon()  {
       header.clickSearchIcon();
    }

    @Then("^I should see list of appropriate products$")
    public void i_should_see_list_of_appropriate_products()  {
       productListPage.validateProductResults();
    }
}
