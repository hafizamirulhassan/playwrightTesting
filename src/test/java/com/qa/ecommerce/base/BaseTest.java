package com.qa.ecommerce.base;

import com.microsoft.playwright.Page;
import com.qa.ecommerce.pages.MyAccountPage;
import com.qa.ecommerce.factory.playwrightFactory;
import com.qa.ecommerce.pages.OrderPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {

    playwrightFactory pf;
    Page page;
    protected Properties prop;
    protected MyAccountPage myAccountPage;
    protected OrderPage orderPage;

    @Parameters({"browser"})
    @BeforeTest
    public void SetUp(String browserName){

        pf= new playwrightFactory();
        prop = pf.init_prop();

        // It will pick the value from testng.xml not from properties file
        if(browserName!=null){
            prop.setProperty("browser", browserName);
        }
        page = pf.initBrowser(prop);
        myAccountPage = new MyAccountPage(page);

    }
    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
