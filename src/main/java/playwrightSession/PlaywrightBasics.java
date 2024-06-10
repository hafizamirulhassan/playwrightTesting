package playwrightSession;

import com.microsoft.playwright.*;

public class PlaywrightBasics {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
            Page page = browser.newPage();
            page.navigate("http://google.com");
            String title = page.title();
            System.out.println("Page title is: "+title);
            String url = page.url();
            System.out.println("Page url is: "+url);
            browser.close(); // To close the browser
            playwright.close(); // To close the server

    }
}