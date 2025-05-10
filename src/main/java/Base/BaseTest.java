package Base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import Utilities.ConfigReader;

public class BaseTest {
	
	private static final ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    public static Playwright playwright; 
    public static Browser browser; 
    public static Page page;
    
    public static void initializeBrowser() {
         playwright = Playwright.create();
        playwrightThreadLocal.set(playwright);

        boolean headless1 = Boolean.parseBoolean(ConfigReader.get("headless"));
        
         browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions().setHeadless(headless1));
        browserThreadLocal.set(browser);

         page = browser.newPage();
        pageThreadLocal.set(page);
    }

    public static Page getPage() {
        return pageThreadLocal.get();
    }

    public static void tearDown() {
         page = pageThreadLocal.get();
         browser = browserThreadLocal.get();
         playwright = playwrightThreadLocal.get();

        if (page != null) page.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();

        // Cleanup thread locals
        pageThreadLocal.remove();
        browserThreadLocal.remove();
        playwrightThreadLocal.remove();
    }
	/*
	 * public static Playwright playwright; public static Browser browser; public
	 * static Page page;
	 * 
	 * public static void initializeBrowser() { playwright = Playwright.create();
	 * boolean headless = Boolean.parseBoolean(ConfigReader.get("browser")); browser
	 * = playwright.chromium().launch(new
	 * BrowserType.LaunchOptions().setHeadless(headless)); page = browser.newPage();
	 * 
	 * }
	 * 
	 * public static void tearDown() { if (page != null) page.close(); if (browser
	 * != null) browser.close(); if (playwright != null) playwright.close(); }
	 */
}
