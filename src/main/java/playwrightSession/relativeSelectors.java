package playwrightSession;

import com.microsoft.playwright.*;

public class relativeSelectors {

    static Page page;
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
        BrowserContext context = browser.newContext();
        page = context.newPage();


        page.navigate("https://selectorshub.com/xpath-practice-page/");

        // Used example --> User Table --> CSS selector
        // Use double $$ in the playwright console because of multiple elements - it is good practice

        // This will capture single element --> playwright.$("input[type='checkbox']:left-of(:text('Joe.Root'))")
        // This will capture list of element --> playwright.$$("input[type='checkbox']:left-of(:text('Joe.Root'))")

//        Locator cssSelect = page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))");
//        cssSelect.first().click();

        selectUser("Joe.Root");
        selectUser("John.Smith");

//        // get the text from userRole using "right-of"
//        String userRole = page.locator("td:right-of(:text('Joe.Root'))").first().textContent();
//        System.out.println(userRole);

        System.out.println(getUserRole("Joe.Root"));

        // get the text from userRole using "right-of"
        String aboveUser = page.locator("a:above(:text('Joe.Root'))").first().textContent();
        System.out.println(aboveUser);


//        browser.close();
//        playwright.close();


    }

    public static void selectUser(String userName){
        Locator cssSelect = page.locator("input[type='checkbox']:left-of(:text('"+userName+"'))");
        cssSelect.first().click();

    }

    public static String getUserRole(String userRole){
        Locator user_role = page.locator("td:right-of(:text('"+userRole+"'))");
        String userRoleText = user_role.first().textContent();
        return userRole;

    }

}