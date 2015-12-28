// This class is responsible for operations related to Product details page. 

package nordea.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class ProductDetailsPage {
   private static final By PRODUCT_TITLE_FIELD = By.id("productTitle");
   private WebDriver driver;
 
   public ProductDetailsPage(WebDriver driver) {
      this.driver = driver;
   }
 
   public String getProductTitle() {
      return driver.findElement(PRODUCT_TITLE_FIELD)
            .getText();
   }
 
}
