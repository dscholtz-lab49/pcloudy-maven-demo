package testRunner;

import drivers.AndroidDriverManager;
import drivers.IOSDriverManager;
import io.cucumber.java.AfterAll;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"stepDefinitions"},
	    plugin = {
	                "pretty",
	                "html:target/cucumber-reports/cucumber-pretty",
	                "json:target/cucumber-reports/CucumberTestReport.json",
					"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		}
)

public class Runner extends AbstractTestNGCucumberTests {

	protected AndroidDriverManager androidDriverManager;
	protected IOSDriverManager iosDriverManager;


	@AfterAll()
	public void tearDown () {
		if (androidDriverManager != null) {
			androidDriverManager.quitDriver ();
		} else if (iosDriverManager != null) {
			iosDriverManager.quitDriver ();
		}
	}

}
