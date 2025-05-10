package StepDefination;


import java.nio.file.Paths;

import com.microsoft.playwright.Page;

import Base.BaseTest;
import Utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	String url = ConfigReader.get("baseurl");

    @Before
    public void setup() {
        BaseTest.initializeBrowser();
        BaseTest.getPage().navigate(url);
    }

    @After
    public void tearDown(Scenario scenario) {
    	if(scenario.isFailed())
    	{
    		BaseTest.getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/Screenshot/screenshot"+scenario.getName()+".png")));
    		System.out.println("Screenshot taken for failed scenario: " + scenario.getName());
    	}
        BaseTest.tearDown();
    }
}

