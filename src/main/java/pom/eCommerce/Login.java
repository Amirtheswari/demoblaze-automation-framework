package pom.eCommerce;

import eCommerceBase.BaseEcommerce;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Driver;
import java.time.Duration;
import java.util.AbstractList;

public class Login  extends BaseEcommerce{
    public Login clickLogin(){
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log in")));
        login.click();
        return this;

    }

    public Login enterLoginName(String Name){
        WebElement loginName = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loginusername"))));
        loginName.sendKeys(Name);
        return this;
    }

    public Login enterLoginPassword(String passWord){
        driver.findElement(By.id("loginpassword")).sendKeys(passWord);
        return this;
    }

    public Login login(){
        driver.findElement(By.xpath("//Button[text()='Log in']")).click();
        return this;
    }

    public String getAlertIfPresent() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));

            Alert alert = shortWait.until(
                    ExpectedConditions.alertIsPresent());

            String message = alert.getText();
            alert.accept();

            return message;

        } catch (TimeoutException e) {
            return null;
        }
    }

}
