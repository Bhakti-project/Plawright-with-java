package StepDefination;

import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.microsoft.playwright.Page;

import Base.BaseTest;
import Exception.LoginFailedException;
import Utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

	String url = ConfigReader.get("baseurl");
	private static final Logger logger = LogManager.getLogger(Hooks.class);
	
	@Before
	public void setup() {

		if (url != null && url.trim().length() != 0) {
			BaseTest.initializeBrowser();
			BaseTest.getPage().navigate(url);
		} else {
			
			
			// System.out.println("URL is not configured or unable to read the url.");
			
				logger.error("URl not find"+url);
				System.err.println("URl is Empty so stop execution");
				//System.exit(0);
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
