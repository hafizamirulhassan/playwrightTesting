package playwrightSession;

import com.microsoft.playwright.*;

import java.util.List;

public class SelectorsORLocatorsPrac {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
//        page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
        page.navigate("https://demo.opencart.com/index.php?route=account/login&language=en-g");
//         //To click on straight forward and it is the only one element on the page
//        page.locator("text = Contact Sales").click();

//        // if multiple elements text found
//        Locator links = page.locator("text = Privacy Policy");
//        for(int i=0; i<links.count(); i++){
//            String totalText = links.nth(i).textContent();
//                if (totalText.contains("Service Privacy Policy")){
//                    links.nth(i).click();
//                    break;
//                }
//        }

        //To locate the element using "has-text"
//        Locator newCustomer = page.locator("h2:has-text('New Customer')");
        // It is Parent to child path - Parent: div.card-body Child: h2
        Locator newCustomer = page.locator("div.card-body h2:has-text('New Customer')");
        String text = newCustomer.textContent();
        System.out.println(text);

        // Whenever you want to capture or use the direct text without having any selector then it will use in single quote ''
        Locator returningCustomer = page.locator("'Returning Customer'");
        // Both are the same thing line 38 & 40
//        Locator returningCustomer2 = page.locator("text =Returning Customer");
        String ReturningCustomerText = returningCustomer.textContent();
        System.out.println(ReturningCustomerText);

        // login Button - parent to child - Login button under form
        Locator loginButton = page.locator("form button:has-text('Login')");
        loginButton.click();
        browser.close();
        playwright.close();


    }
}