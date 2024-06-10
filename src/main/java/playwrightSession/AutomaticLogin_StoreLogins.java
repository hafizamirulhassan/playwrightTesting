package playwrightSession;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class AutomaticLogin_StoreLogins {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Locator userName = page.locator("xpath = //input[contains(@name, 'username')]");
        userName.fill("Admin");
        Locator password = page.locator("xpath = //input[contains(@name, 'password')]");
        password.fill("admin123");
        Locator loginBTN = page.locator("xpath = //button[@type=\"submit\"]");
        loginBTN.click();
        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("appLogin.json")));






//        browser.close();
//        playwright.close();


    }
}