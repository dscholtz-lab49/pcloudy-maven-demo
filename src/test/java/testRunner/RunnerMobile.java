package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import listener.CustomListener;
import org.testng.annotations.Listeners;


@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"stepDefinitions"},
	    plugin = {
	                "pretty",
	                "html:target/cucumber-reports/cucumber-pretty",
	                "json:target/cucumber-reports/CucumberTestReport.json",
					"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
					"listener.CustomEventListener"
		},
		tags = "@TestMobile"
)
@Listeners(CustomListener.class)
public class RunnerMobile extends AbstractTestNGCucumberTests {

}
