package playwrightSession;

import com.microsoft.playwright.*;

import java.awt.*;
import java.awt.geom.Arc2D;

public class MaxmimizeScreen {
    public static void main(String[] args) {

        // Java API - ToolKit
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        System.out.println(width+ ":" +height);


        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);

        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
        Page page = context.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        browser.close();
        playwright.close();


    }
}