package stepDefinitions.web;

import drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.web.HomePage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.testng.Assert.assertTrue;

public class WebSteps {

    private WebDriver webDriver;
    private DriverManager driverManager;

    public WebSteps() {
        driverManager = new DriverManager();
    }

    @BeforeAll()
    public static void cleanUp() {
        String screenshotFolder = "screenshots/";
        File folder = new File(screenshotFolder);
        try {
            FileUtils.cleanDirectory(folder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before(value = "@TestWeb", order = 1)
    public void setUp() {
        webDriver = driverManager.createAndroidDriver("chrome");
    }

    @After(order = 1)
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) webDriver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                String dest = "screenshots/" + scenario.getName().replace(" ", "_") + ".png";
                File destination = new File(dest);
                FileUtils.copyFile(source, destination);

                try {
                    Allure.addAttachment("Screenshot", Files.newInputStream(Paths.get(dest)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    @After(value = "@TestWeb", order = 0)
    public void tearDown () {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Given("^User opens ABCB website$")
    public void openSite() {
        webDriver.get("https://www.adcb.com/en/personal/");
        webDriver.manage().window().maximize();
    }


    @Then("^Personal menu is visible$")
    public void personalMenuIsVisible() {
        HomePage homePage = new HomePage(webDriver);
        assertTrue(homePage.isPersonalMenuDisplayed());
    }

    @Then("^Business menu is visible$")
    public void businessMenuIsVisible() {
        HomePage homePage = new HomePage(webDriver);
        assertTrue(homePage.isBusinessMenuDisplayed());
    }
}
