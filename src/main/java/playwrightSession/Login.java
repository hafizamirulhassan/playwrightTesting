package playwrightSession;

import com.microsoft.playwright.*;

import java.net.StandardSocketOptions;

public class Login {
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
//        Locator loginBTN = page.locator("xpath = //button[@type=\"submit\"]");

        // if multiple locators / elements available then you can use first() , last() etc options
        // To check how many text Login available then you can use count() option.
//        Locator loginBTN = page.locator("text = Login").count();

//        Locator loginBTN = page.locator("text = Login").first();
//        loginBTN.click();

        Locator loginBTN = page.locator("text = Login");
        int totalLoginElement = loginBTN.count();
        System.out.println(totalLoginElement);
        loginBTN.first().click();








//        You can locate the element by the text it contains:
//        assertThat(page.getByText("Welcome, John")).isVisible();
//
//        Set an exact match:
//        assertThat(page
//                .getByText("Welcome, John", new Page.GetByTextOptions().setExact(true)))
//                .isVisible();
//
//        Match with a regular expression:
//        assertThat(page
//                .getByText(Pattern.compile("welcome, john$", Pattern.CASE_INSENSITIVE)))
//                .isVisible();

        browser.close();
        playwright.close();


    }
}