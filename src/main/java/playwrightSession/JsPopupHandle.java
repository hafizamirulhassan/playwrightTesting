package playwrightSession;

import com.microsoft.playwright.*;

public class JsPopupHandle {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
            Page page = browser.newPage();
            // Custom Listeners --> in this way we can capture the message and print the exact message for all alerts
            page.onDialog(dialog -> {
                String promptMessage = dialog.message();
                System.out.println(promptMessage);
//                dialog.accept();
                // if you want to enter value in the prompt alert then use accept overloaded method --> accept(String promptText)
                dialog.accept("Hi this is alert prompt from amir");
//                dialog.dismiss();
            });
            page.navigate("https://testpages.eviltester.com/styled/alerts/alert-test.html");

            // Alert box
        Locator alertBox = page.locator("input#alertexamples");
        alertBox.click();

//        // You can click directly using page.click
//        page.click("input#alertexamples");

        // Confirm Box
        Locator confirmBox = page.locator("input#confirmexample");
        confirmBox.click();
        String confirmText = page.textContent("p#confirmexplanation");
        System.out.println(confirmText);

        // Prompt Alert
        Locator promptClick = page.locator("input#promptexample");
        promptClick.click();
        String promptMessage = page.textContent("p#promptexplanation");
        System.out.println(promptMessage);



        page.close();
        browser.close();
        playwright.close();


    }
}