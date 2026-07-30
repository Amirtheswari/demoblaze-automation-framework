package pom.eCommerce;

import eCommerceBase.BaseEcommerce;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class PlaceOrder extends BaseEcommerce {
    public PlaceOrder placeOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Cart']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']"))).click();
        return this;

    }

    public PlaceOrder details(String name, String country, String city, String card, String month, String year){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys(name);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("card")).sendKeys(card);
        driver.findElement(By.id("month")).sendKeys(month);
        driver.findElement(By.id("year")).sendKeys(year);
        return this;
    }

    public void purchase(){
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']"))).click();
    }
}
