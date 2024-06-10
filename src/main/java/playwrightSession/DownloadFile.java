package playwrightSession;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class DownloadFile {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=2.0/");

        Download download = page.waitForDownload(()-> {
            page.click("a:text('chromedriver_win32.zip')");
        });
        System.out.println(download.url());
//        String downloadedFileTitle = download.page().title();
//        System.out.println(downloadedFileTitle);

        // Print the temporary downloaded path
        String path  = download.path().toString();
        System.out.println(path);

                                             // to save your own path

        // wrong way to add downloaded file path
//        download.saveAs("downloaded_chrome.zip");

        // correct way to add downloaded path --> it will add in my current project directory
        download.saveAs(Paths.get("downloaded_chrome.zip")); // It will create a copy from temporary file to this path.


        // You can cancel the download
//        download.cancel();
        // suggested file name
//        download.suggestedFilename();

        // to check the failure of downloaded file
//        download.failure();


//        browser.close();
//        playwright.close();


    }
}