package pom.eCommerce;

import eCommerceBase.BaseEcommerce;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Visibility;
import java.time.Duration;

public class SignUp extends BaseEcommerce{
    public SignUp signUp(){
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign up"))).click();
        return this;
    }
    public SignUp enterUsername(String userName){
        wait.until(ExpectedConditions.elementToBeClickable((By.id("sign-username")))).sendKeys(userName);
        return this;
    }
    public SignUp enterPassword(String passWord){
        driver.findElement(By.id("sign-password")).sendKeys(passWord);
        return this;
    }
    public void submit(){
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        driver.findElement(By.xpath("(//span[text()='×'])[position()=2]")).click();
    }
}
