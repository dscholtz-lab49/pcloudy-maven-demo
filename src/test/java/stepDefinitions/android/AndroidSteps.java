package stepDefinitions.android;

import drivers.AndroidDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Platform;
import pages.android.LoginPage;
import stepDefinitions.BaseSteps;

import static org.testng.Assert.assertTrue;

public class AndroidSteps extends BaseSteps {
    protected static AndroidDriverManager androidDriverManager;

    @Before("@TestMobile")
    public static void setUp() {
        androidDriverManager = AndroidDriverManager.builder ()
                .platform (Platform.ANDROID)
                .platformVersion ("12.0.0")
                .build ()
                .createAndroidDriver ();
    }

    @After("@TestMobile")
    public static void tearDown () {
        if (androidDriverManager != null) {
            androidDriverManager.quitDriver();
        }
    }

    @Given("^User install \"([^\"]*)\"$")
    public void userInstallApp(String app) {
        // do nothing, it is already specified
    }

    @When("^User opens \"([^\"]*)\"$")
    public void userOpenApp(String app) {
        // do nothing, it is already specified
    }

    @Then("^Application is loaded with all elements$")
    public void elementsAreLoaded() {
        LoginPage loginPage = new LoginPage(androidDriverManager);
        assertTrue(loginPage.isUsernameFieldDisplayed());
        assertTrue(loginPage.isPasswordFieldDisplayed());
        assertTrue(loginPage.isLoginButtonDisplayed());
    }
}
