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

///*	public String test() {
//		//.url..4
//		return ".."; url="";
//	}*/
	
	@Before
	public void setup() {
		BaseTest.initializeBrowser();
		if (url != null && url.trim().length() != 0) {
			BaseTest.getPage().navigate(url);
		} else {
			System.out.println("URL is not configured or unable to read the url.");
			
		//	System.err.println("Property '"+url+"' is undefined in config.properties!");
		}
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			BaseTest.getPage().screenshot(new Page.ScreenshotOptions()
					.setPath(Paths.get("target/Screenshot/screenshot" + scenario.getName() + ".png")));
			System.out.println("Screenshot taken for failed scenario: " + scenario.getName());
		}
		BaseTest.tearDown();
	}
}
