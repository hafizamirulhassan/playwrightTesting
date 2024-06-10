package com.qa.ecommerce.pages;

import com.microsoft.playwright.Page;

import java.security.PublicKey;

public class OrderPage {

    private Page page;

    private final String goShop = "//a[contains(text(), 'Go Shop')]";
    public OrderPage(Page page){
        this.page=page;
    }

    public String getOrderPageURL(){
        String expectedURL = page.url();
        System.out.println("Your expected Order Page URL:"+expectedURL);
        return expectedURL;
    }

    public String getOrderPageTitle(){
        String expectedOrderTitle = page.title();
        System.out.println("Your expected Order Title:"+expectedOrderTitle);
        return expectedOrderTitle;
    }
    public boolean getVerifyGoShop(){

        if(page.isVisible(goShop)){
            System.out.println("Link displayed");
            return true;
        }return false;

    }
}
