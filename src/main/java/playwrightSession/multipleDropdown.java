package playwrightSession;

import com.microsoft.playwright.*;

import java.util.List;

public class multipleDropdown {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://www.orangehrm.com/en/30-day-free-trial");

//        // Single Element code
//        Locator loginBTN = page.locator("text = Login");
//        int totalLoginElement = loginBTN.count();
//        System.out.println(totalLoginElement);
//        loginBTN.first().click();


        // For Multiple Elements
        Locator countryDropdownOptions = page.locator("select#Form_getForm_Country option");
        System.out.println(countryDropdownOptions.count());
        // get all the country text using for loop - textContent (to get text)

        // 1 way

//        for(int i=0; i< countryDropdownOptions.count(); i++){
//            String countryText = countryDropdownOptions.nth(i).textContent();
//            System.out.println(countryText);
//        }

        // 2nd way - Using allTextContent

        List<String> countryTextList = countryDropdownOptions.allTextContents();
        for(String e: countryTextList){
            System.out.println(e);
        }

//        // 3rd way - using Lambda function
//
//        List<String> countryTextList = countryDropdownOptions.allTextContents();
//        countryTextList.forEach(ele -> System.out.println(ele));


        browser.close();
        playwright.close();


    }
}