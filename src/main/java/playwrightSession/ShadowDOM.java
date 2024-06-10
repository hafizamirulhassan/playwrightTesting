package playwrightSession;

import com.microsoft.playwright.*;

public class ShadowDOM {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        // ShadowDOM practise site as well https://selectorshub.com/xpath-practice-page/
        page.navigate("https://books-pwakit.appspot.com/");

        // - Locate the element: Jump to parent of shadow root first then pick the desired particular element as child

        Locator inputSearch = page.locator("book-app[apptitle='BOOKS'] #input");
        inputSearch.fill("Test Book");
        Locator captureWorldText = page.locator("book-app[apptitle='BOOKS'] .books-desc");
        String actualText = captureWorldText.textContent();
        System.out.println(actualText);

        // In Playwright There is not need to use javascript executor or document.query etc.

//        // Selenium example shadowDOM code  to compare
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement startButton = (WebElement) ((
//                js.executeScript("return document.querySelector("body > book-app.shadowRoot#input");
//        startButton.sendKeys(Keys.ENTER);

        browser.close();
        playwright.close();


    }
}