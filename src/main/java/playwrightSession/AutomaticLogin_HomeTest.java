package playwrightSession;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class AutomaticLogin_HomeTest {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("appLogin.json")));
        Page page = context.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//        browser.close();
//        playwright.close();


    }
}