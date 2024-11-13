package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Main {
    public static void main(String[] args) {

        Playwright pw = Playwright.create();

        BrowserType browserType = pw.chromium();

        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://allpoketcg.com/");

        String title = page.title();

        System.out.println("The title is: " + title);

        //page.close();
        //browser.close();
        //pw.close();

    }
}