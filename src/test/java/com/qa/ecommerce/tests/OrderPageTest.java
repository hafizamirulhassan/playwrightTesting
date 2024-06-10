package com.qa.ecommerce.tests;

import com.qa.ecommerce.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseTest {

    @Test
    public void navigateToOrderPageTest() throws InterruptedException {

        myAccountPage.getLogin(prop.getProperty("email").trim(), prop.getProperty("password").trim());
        orderPage = myAccountPage.navigateToOrderPage();
        String actualURL = orderPage.getOrderPageURL();
        Assert.assertEquals(actualURL, "https://practice.automationtesting.in/my-account/orders/");
        Assert.assertTrue(orderPage.getVerifyGoShop());
    }
}
