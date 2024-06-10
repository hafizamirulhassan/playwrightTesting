package com.qa.ecommerce.tests;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountPageTest extends BaseTest {

        // When you want to multi try i.e. Search field -
//    @DataProvider
//    public Object[][] LoginData(){
//        return new Object[][]{
//
//                {"fiha0095@gmail.com", "fiha0095@"},
//                {"fiha0095@gmail.com", "fiha0095@"}
//        };
//    }

    @Test
    public void homePageURLTest(){
        String actualURL = myAccountPage.getHomePageURL();
        Assert.assertTrue(actualURL.contains(prop.getProperty("url")), "URL does not contain the expected text.");
    }
    @Test
    public void homePageTitleTest() throws InterruptedException {
        String actualTitle = myAccountPage.getHomePageTitle();
        Assert.assertTrue(actualTitle.contains(AppConstants.LOGIN_PAGE_TITLE), "Title does not contain the expected text.");
    }

    @Test
    public void getLoginPageTest() throws InterruptedException {
        String actualUserName = myAccountPage.getLogin(prop.getProperty("email"), prop.getProperty("password"));
        Assert.assertEquals(actualUserName, AppConstants.LOGGED_IN_USERNAME);

    }

//    @Test(dataProvider= "LoginData")
//    public void getLoginPageTest(String userEmail, String userPassword) throws InterruptedException {
//        String actualUserName = homePage.getLogin(userEmail, userPassword);
//        Assert.assertEquals(actualUserName, "fiha0095");
//    }

}
