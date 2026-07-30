package eCommerceBase;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;

import java.time.Duration;

/** Ecommerce Automation Framework - Base Class
 *
 */
public class BaseEcommerce {
        protected static RemoteWebDriver driver = null;
        protected static WebDriverWait wait;
        String url = "https://www.demoblaze.com/";

        @BeforeMethod
        public void start(){
            String browser = PropertyReader.getProperty("browser");
            if(browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
            }
            int timeOut = Integer.parseInt(PropertyReader.getProperty("timeout"));
            wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            driver.manage().window().maximize();
            driver.get(PropertyReader.getProperty("url"));
        }

        @AfterMethod
        public void quit(){
            driver.quit();
        }

}
