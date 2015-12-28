

// Takes care of searching and sorting results. This can be extended to handle all 
// search, sort and filtering
package nordea.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import nordea.automation.pages.SearchResultsPage;
 
public class NavigationMenu {
   private static final By SEARCH_SORT_ITEM = By.id("sort");
   private static final By SEARCH_INPUT = By.id("twotabsearchtextbox");
   private static final By SEARCH_GO_BUTTON = By.xpath("//*[@value='Go']");
   private WebDriver driver;
 
   public NavigationMenu(WebDriver driver) {
      this.driver = driver;
   }
 
   public SearchResultsPage searchFor(String searchKey) {
      
      driver.findElement(SEARCH_INPUT)
            .sendKeys(searchKey);
      driver.findElement(SEARCH_GO_BUTTON)
            .click();
      return new SearchResultsPage(driver);
   }

  public SearchResultsPage sortByPriceHighToLow() {
	  Select dropdown = new Select(driver.findElement(SEARCH_SORT_ITEM));
      dropdown.selectByValue("price-desc-rank");
      return new SearchResultsPage(driver);
   }
 
}

