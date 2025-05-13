package Runnner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "StepDefination", "Hooks" },
tags= "@Smoke", plugin = { "pretty","html:target/Smokereport.html" }, monochrome = true, dryRun = false)
public class TestRunnerforSmoke {

}
