package playwrightSession;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;

public class WindowPopups {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);

        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//        // TO navigate to new open browser window / tab --> it will be like new Page because it's opening in new window
//        Page popupPage = page.waitForPopup(() ->{
//            page.click("xpath = //a[contains(@href, 'twitter')]");
//        });
//        popupPage.waitForLoadState();
//        System.out.println("Your popup window title: "+popupPage.title());
//        popupPage.close();
//        System.out.println("Parent Window Title: "+page.title());
//        page.close();

        // To open the new blank window tab and enter the url as per need -

        Page blankWindow = page.waitForPopup(() ->{
           page.click("a[target='_blank']");
        });
        blankWindow.waitForLoadState();
        // Launching the Google into new open blank window
        blankWindow.navigate("https://www.google.com");
        System.out.println("Your popup window title: "+blankWindow.title());
        blankWindow.close();
        System.out.println("Parent Window Title: "+page.title());
        page.close();


        // This is for to open 2 browser context with 2 pages as well

//        BrowserContext context1 = browser.newContext();
//        BrowserContext context2 = browser.newContext();
//
//        Page page1 = context1.newPage();
//        Page page2 = context2.newPage();
//
//        page1.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        page2.navigate("https://formstone.it/components/upload/demo/");

        // www.google.com --> protocol error will through and invalid URL


    }
}