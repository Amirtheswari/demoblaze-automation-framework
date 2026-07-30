package eCommerce.Test;

import eCommerceBase.BaseEcommerce;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.eCommerce.AddToCart;
import pom.eCommerce.Login;
import pom.eCommerce.PlaceOrder;
import pom.eCommerce.SignUp;

import java.io.IOException;
import java.util.logging.Logger;

public class TC01 extends BaseEcommerce {
    //private static int rowIndex = 0;
    @DataProvider(name = "loginData")
    public String[][] loginData() throws IOException {
        return readFromExcel.getDataFromExcel();
    }

    @Test(dataProvider = "loginData")
    public void test(String[] data) throws IOException {
        new SignUp()
                .signUp()
                .enterUsername(data[0])
                .enterPassword(data[1])
                .submit();

       Login loginPage = new Login();
        loginPage
                .clickLogin()
                .enterLoginName(data[0])
                .enterLoginPassword(data[1])
                .login();

        String alertText = loginPage.getAlertIfPresent();

        if(alertText != null) {

            System.out.println("Login Failed");
            System.out.println(alertText);

        }
        else {

            System.out.println("Login Success");

            new AddToCart().cart();
            String[] orderData =
                    readFromExcel.getOrderDataByUser(data[0]);

            String name = orderData[0];
            String country = orderData[1];
            String city = orderData[2];
            String card = orderData[3];
            String month = orderData[4];
            String year = orderData[5];


            new PlaceOrder()
                    .placeOrder()
                    .details(name,country,city,card,month,year)
                    .purchase();

        }
        //rowIndex++;
    }
}
