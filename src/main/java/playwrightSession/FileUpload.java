package playwrightSession;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUpload {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
//        page.navigate("https://formstone.it/components/upload/demo/");
        page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");

        // input type = File --> setinputFile Method

//        // Select one file
//        page.setInputFiles("input.fs-upload-input", Paths.get("C:\\Users\\HP\\Downloads\\text1.doc"));
//        // remove specific file / Deselect - Create object of new Path[] array
//        Thread.sleep(6000);
//        page.setInputFiles("input.fs-upload-input", new Path[0]);
//        Thread.sleep(6000);

//        // multiple files
//
//        page.setInputFiles("input.fs-upload-input", new Path[]
//                {Paths.get("C:\\Users\\HP\\Downloads\\text1.doc"),
//                        Paths.get("C:\\Users\\HP\\Downloads\\text2.doc"),
//                        Paths.get("appLogin.json")});
//        Thread.sleep(6000);
//        page.setInputFiles("input.fs-upload-input", new Path[0]);
//        Thread.sleep(6000);

        // Run time file upload

//        page.setInputFiles("input.fs-upload-input", new FilePayload("amir_run_time_file.txt",
//                "text/plain",
//                "this is amir here"
//                        .getBytes(StandardCharsets.UTF_8)));
//        Thread.sleep(6000);


        // Verify uploaded run time file either content is fine or same or not.
                page.setInputFiles("input[name='upfile']", new FilePayload("amir_run_time_file.txt",
                "text/plain",
                "this is amir here"
                        .getBytes(StandardCharsets.UTF_8)));
        Thread.sleep(2000);
        page.click("input[value='Press']");
        Thread.sleep(6000);

//        - How to check which file is there
//        - you have to check MIME file
//                - PDF --> application/pdf
//                - txt --> text/plain
//                - zip --> application/zip
//                - audio file --> audio/mpeg


        browser.close();
        playwright.close();


    }
}