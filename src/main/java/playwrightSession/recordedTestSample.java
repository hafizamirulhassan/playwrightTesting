package playwrightSession;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class recordedTestSample {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.google.com/?gws_rd=ssl");
            page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).click();
            page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).fill("a b c d");
            page.getByRole(AriaRole.SEARCH).getByRole(AriaRole.IMG).first().click();
            page.navigate("https://www.google.com/search?q=a+b+c+d&sca_esv=584912597&source=hp&ei=Ba1fZdyaOM6LoATEzYDgAg&iflsig=AO6bgOgAAAAAZV-7FXe2mWgzxP3tdAI-Fp_h9ACe8y_i&ved=0ahUKEwicsf6u8tqCAxXOBYgKHcQmACwQ4dUDCAo&uact=5&oq=a+b+c+d&gs_lp=Egdnd3Mtd2l6IgdhIGIgYyBkMgUQLhiABDIFEC4YgAQyBRAuGIAEMgUQABiABDIFEC4YgAQyBRAAGIAEMgUQLhiABDIFEAAYgAQyBRAuGIAEMgUQABiABEjwZVD-CliRIHABeACQAQCYAZcCoAHODaoBAzItN7gBA8gBAPgBAagCCsICEBAAGAMYjwEY5QIY6gIYjAPCAhAQLhgDGI8BGOUCGOoCGIwDwgILEAAYgAQYsQMYgwHCAhEQLhiABBixAxiDARjHARjRA8ICCxAuGIAEGLEDGIMBwgIOEAAYgAQYigUYsQMYgwHCAg4QLhiABBixAxjHARjRA8ICCBAAGIAEGLEDwgIOEC4YgwEYsQMYgAQYigU&sclient=gws-wiz");
        }
    }
}