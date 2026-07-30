package pom.eCommerce;

import eCommerceBase.BaseEcommerce;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCart  extends BaseEcommerce{
    public void cart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Welcome ')]")));
        WebElement product =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Samsung galaxy s6')]")));
        product.click();
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart")));
        cart.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

    }
}
