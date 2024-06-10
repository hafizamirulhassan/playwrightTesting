package com.qa.ecommerce.pages;

import com.microsoft.playwright.Page;

public class MyAccountPage {

    private Page page;
    // 1. String Locators - OR

    private final String email = "//input[@name='username']";
    private final String password = "//input[@name='password']";
    private final String loginBTN = "//input[@name='login']";
    private final String verifyUserName = "//strong[contains(text(), 'fiha0095')]";
    private final String orderLink = "//a[contains(text(), 'Orders')]";


    //2.  Constructor
    public MyAccountPage(Page page){
        this.page=page;
    }

    // 3. Page actions
    public String getHomePageTitle(){
       String expectedTitle = page.title();
       System.out.println("Title:"+expectedTitle);
       return expectedTitle;
    }

    public String getHomePageURL(){
        String expectedURL = page.url();
        System.out.println("URL:"+expectedURL);
        return expectedURL;
    }

    public String getLogin(String Email, String Password) throws InterruptedException {

        page.fill(email, Email);
        Thread.sleep(2000);
        page.fill(password, Password);
        page.click(loginBTN);
        String expectedUserName = page.textContent(verifyUserName);
        System.out.println("User Name:"+expectedUserName);
        return expectedUserName;
    }

    public OrderPage navigateToOrderPage(){
        page.click(orderLink);
        return new OrderPage(page);
    }

}
