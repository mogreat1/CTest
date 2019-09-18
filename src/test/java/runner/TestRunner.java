package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions",
        monochrome = true,
        strict = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}
