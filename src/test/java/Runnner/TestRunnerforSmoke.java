package Runnner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
        "src/test/resources/Features/login.feature",
        "src/test/resources/Features/registration.feature",
        "src/test/resources/Features/checkout.feature"
    },
	 glue = { "StepDefination", "Hooks" },
tags= "@Order1 or  @Order2 or  @Order3", plugin = { "pretty","html:target/report.html" }, monochrome = true, dryRun = false)
public class TestRunnerforSmoke {

}
