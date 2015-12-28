// Find the second item from search results and click to open product page

package nordea.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class SearchResultsPage {
   private static final By SEARCH_RESULT_ITEM_TITLE = By.xpath("//*[@id='result_1']/div");
   private WebDriver driver;
   public SearchResultsPage(WebDriver driver) {
      this.driver = driver;
   } 
  
   public ProductDetailsPage clickSecondResultTitle() {
	   
	   driver.navigate().refresh();
	   driver.findElement(SEARCH_RESULT_ITEM_TITLE)
            .click();
      return new ProductDetailsPage(driver);
   }
}
