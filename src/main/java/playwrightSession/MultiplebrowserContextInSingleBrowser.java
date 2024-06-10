package playwrightSession;

import com.microsoft.playwright.*;

public class MultiplebrowserContextInSingleBrowser {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
        BrowserContext context1 = browser.newContext();
        Page page = context1.newPage();
            page.navigate("http://google.com");
            String title = page.title();
            System.out.println("Page title is: "+title);
            String url = page.url();
            System.out.println("Page url is: "+url);
            context1.close();

        BrowserContext context2 = browser.newContext();
        Page page2 = context2.newPage();
        page2.navigate("http://facebook.com");
        String title2 = page2.title();
        System.out.println("Page title is: "+title2);
        String url2 = page2.url();
        System.out.println("Page url is: "+url2);
        context2.close();
        playwright.close();


        //You can close the pages like
//            page.close();
//            context1.close();
//
//            page2.close();
//            context2.close();


        // Example Code
//        try (Playwright playwright = Playwright.create()) {
//            BrowserType chromium = playwright.chromium();
//            // Create a Chromium browser instance
//            Browser browser = chromium.launch();
//            // Create two isolated browser contexts
//            BrowserContext userContext = browser.newContext();
//            BrowserContext adminContext = browser.newContext();
//            // Create pages and interact with contexts independently
//        }

    }
}