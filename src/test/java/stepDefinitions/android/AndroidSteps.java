package stepDefinitions.android;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.android.LoginPage;
import stepDefinitions.BaseSteps;

import static org.testng.Assert.assertTrue;

public class AndroidSteps extends BaseSteps {

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
