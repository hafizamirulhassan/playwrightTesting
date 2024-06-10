package playwrightSession;

import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Paths;

public class VideoRecorder {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);

        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myVideos/")).setRecordVideoSize(700, 500));
        Page page = context.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Locator userName = page.locator("xpath = //input[contains(@name, 'username')]");
        userName.fill("Admin");
        Locator password = page.locator("xpath = //input[contains(@name, 'password')]");
        password.fill("admin123");

        Locator loginBTN = page.locator("text = Login");
        int totalLoginElement = loginBTN.count();
        System.out.println(totalLoginElement);
        loginBTN.first().click();




        context.close();
        page.close();
        playwright.close();


    }
}