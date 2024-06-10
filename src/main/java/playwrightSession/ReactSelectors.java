package playwrightSession;

import com.microsoft.playwright.*;

import java.util.List;

public class ReactSelectors {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();


        page.navigate("https://www.netflix.com/pk/");
        Locator enterEmail = page.locator("_react=Anonymous[name='email'] >> input");
        enterEmail.first().fill("abc");

        Locator footer = page.locator("_react=Anonymous[data-uia='footer-link']");
//        List<String> footerLinksList = footer.allInnerTexts();
//        for(String e: footerLinksList){
//            System.out.println(e);
//        }
        footer.allInnerTexts().forEach(e -> System.out.println(e));

//        browser.close();
//        playwright.close();


    }
}