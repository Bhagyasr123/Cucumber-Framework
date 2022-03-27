package runner;

import org.junit.runner.RunWith;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:feature", glue = { "stepdefinitions" }, monochrome = true, tags = {
		"@tag1" }, dryRun = false, strict = true)

public class TestRunner{

}
