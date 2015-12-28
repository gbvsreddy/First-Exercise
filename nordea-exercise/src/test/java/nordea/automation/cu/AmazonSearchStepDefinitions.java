//Contains step definitions corresponding to Cucumber feature file "First.feature"

package nordea.automation.cu;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nordea.automation.pages.HomePage;
import nordea.automation.pages.ProductDetailsPage;
import nordea.automation.pages.SearchResultsPage;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AmazonSearchStepDefinitions {
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    ProductDetailsPage productDetailsPage;

    @Before
    public void prepare() throws Exception { 
    	driver = new FirefoxDriver();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   }

	@After
    public void cleanUp() throws Exception {
        driver.quit();
    }

    @Given("^Amazon home page is open$")
    public void prepareHomePage() {
    	homePage = new HomePage(driver).open();
    }

    @When("^User searches for (.*)$")
    public void search(String item) {
    	searchResultsPage = homePage.navigationMenu()
                .searchFor(item);        
    }
    
    @And("^Sorts results by price : high to low$")
    public void sort() {
    	searchResultsPage = homePage.navigationMenu()
                .sortByPriceHighToLow();        
    }
    
    @And("^Opens the second item$")
    public void openSecondItem() {
    	
    	productDetailsPage = searchResultsPage.clickSecondResultTitle();
    }
    
    @Then("^Product title of opened item contains (.*)$")
    public void assertTheSearchResult(String itemName) {
    	
        assert (productDetailsPage.getProductTitle()
                .contains(itemName));
    }
}
