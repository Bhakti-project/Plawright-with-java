package Runnner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "StepDefination",
		"Hooks" }, tags = "not @skip", 
		plugin = { "pretty", "html:target/AllTestcasereport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
		monochrome = true, dryRun = false)
public class TestRunner {

}