package Runnner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "StepDefination", "Hooks" },
tags= "@Regression", plugin = { "pretty","html:target/Regressionreport.html" }, monochrome = true, dryRun = false)
public class TestRunnerforRegression {

}


//for using cmd is :- mvn test -Dcucumber.filter.tags="@Regression"