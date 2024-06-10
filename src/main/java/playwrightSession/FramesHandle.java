package playwrightSession;

import com.microsoft.playwright.*;

public class FramesHandle {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        // This is for Frames
//        page.navigate("https://www.londonfreelance.org/courses/frames/index.html");

////        Locator frames = page.frameLocator("frame[name='main']").locator("h2");
//        Locator frames = page.frame("main").locator("h2");
//        String headerH2 = frames.textContent();
//        System.out.println(headerH2);

        // This is for IFrames
        page.navigate("https://www.formsite.com/templates/registration-form-templates/club-registration-signup-form/");
        Locator clickRegistrationImg = page.locator("//div[contains(@id, 'imageTemplateContainer')]/img");
        clickRegistrationImg.click();

        Locator enterName = page.frameLocator("//iframe[contains(@id, 'frame-one')]").locator("//input[contains(@id, 'RESULT_TextField-3')]");
        enterName.fill("amir");


        browser.close();
        playwright.close();


    }
}