package stepDefinitions.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.web.HomePage;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class WebSteps {

    private WebDriver webDriver;

    @Before("@TestWeb")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");
        webDriver = new ChromeDriver(chromeOptions);
    }

    @After("@TestWeb")
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
