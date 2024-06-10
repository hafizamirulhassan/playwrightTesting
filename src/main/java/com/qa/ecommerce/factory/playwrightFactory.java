package com.qa.ecommerce.factory;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class playwrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;

    // Thread Local - It will create a local copy for each - for multiple threads
    private static final ThreadLocal<Browser> tlbrowser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> tlbrowserContext = new ThreadLocal<>();
    private static final ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static final ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

    public static Browser getbrowser(){
        return tlbrowser.get();
    }
    public static Playwright getPlaywright(){
        return tlPlaywright.get();
    }
    public static BrowserContext getBrowserContext(){
        return tlbrowserContext.get();
    }
    public static Page getPage(){
        return tlPage.get();
    }

    public Page initBrowser(Properties prop){
        String browserName = prop.getProperty("browser").trim();
        System.out.println("Browser Name Is:"+browserName);
//        playwright = Playwright.create();
        tlPlaywright.set(Playwright.create());

        switch (browserName){
            case "chromium":
//                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlbrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "firefox":
//                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlbrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "safari":
//                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlbrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "chrome":
//                browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
                tlbrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false)));
                break;
            case "edge":
//                browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
                tlbrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(false)));
                break;
            default:
                System.out.println("Please pass the right browser");
                break;
        }

        tlbrowserContext.set(getbrowser().newContext()); // This is for ThreadLocal
//        browserContext= browser.newContext();         // This is for normal behavior
        tlPage.set(getBrowserContext().newPage());
//        page = browserContext.newPage();
        getPage().navigate(prop.getProperty("url"));
//        page.navigate(prop.getProperty("url"));

        return getPage();

    }

    // This method is used to initialize the properties from config file
    public Properties init_prop(){
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            prop = new Properties();
            prop.load(ip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }
    public static String takeScreenshot(){
        String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis() +".png";
        getPage().screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(path))
                .setFullPage(true));
                return path;
    }
}
