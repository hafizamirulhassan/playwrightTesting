package playwrightSession;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class TraceViewer {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create(); // Playwright is the interface not a class
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
        BrowserContext context = browser.newContext();

        // Start tracing before creating / navigating a page

        context.tracing().start(new Tracing.StartOptions() // Tracing is the interface not a class
                .setScreenshots(true)
                .setSnapshots(true));

        Page page = context.newPage();
            page.navigate("http://google.com");
            String title = page.title();
            System.out.println("Page title is: "+title);
            String url = page.url();
            System.out.println("Page url is: "+url);

            // Stop the tracing
        // NOTE: You can use before method and after method to start and stop the tracing
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));

            browser.close(); // To close the browser
            playwright.close(); // To close the server


    }
}