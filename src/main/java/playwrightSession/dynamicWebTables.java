package playwrightSession;

import com.microsoft.playwright.*;

public class dynamicWebTables {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();


        // https://primeng.org/table

        page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
        Locator rows = page.locator("table#example tr");
        // Below is the overloaded locator
        rows.locator(":scope", new Locator.LocatorOptions()
                .setHasText("Ashton Cox"))
                .locator(".select-checkbox")
                .click();
        // Printing all the table with format as it is using "SCOPE"
        rows.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));

        browser.close();
        playwright.close();


    }
}