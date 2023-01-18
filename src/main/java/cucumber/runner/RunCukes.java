package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "./src/main/java/cucumber/features/EMPLOYEE.feature", glue = "cucumber.steps")

public class RunCukes extends AbstractTestNGCucumberTests {

}
