package playwrightSession;

import com.microsoft.playwright.*;

import java.util.List;

public class VisibleElements {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();


        page.navigate("https://www.formsite.com/templates/registration-form-templates/club-registration-signup-form/");

//        Locator VisibleText = page.locator("button:visible");
//        //OR
//        //         Locator VisibleText = page.locator("button >> visible=true");
//        String actualText = VisibleText.textContent();
//        System.out.println(actualText);

        Locator links = page.locator("a:visible");
        List<String> allLinkText = links.allInnerTexts();
        for (int i =0; i<allLinkText.size(); i++){
            System.out.println(allLinkText.get(i));
        }

        Locator imgCount = page.locator("xpath=//img >> visible=true");
        System.out.println(imgCount.count());

        //xpath=//img >> visible=true
        // text = Login >> visible=true

        browser.close();
        playwright.close();


    }
}