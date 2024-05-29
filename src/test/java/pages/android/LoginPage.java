package pages.android;

import drivers.AndroidDriverManager;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "io.perfecto.expense.tracker:id/login_email")
    private WebElement usernameField;

    @FindBy(id = "io.perfecto.expense.tracker:id/login_password")
    private WebElement passwordField;

    @FindBy(id = "io.perfecto.expense.tracker:id/login_login_btn")
    private WebElement loginButton;

    public LoginPage(AndroidDriverManager androidDriverManager) {
        super(androidDriverManager);
        PageFactory.initElements(androidDriverManager.getDriver(), this);
    }

    public boolean isElementDisplayed(WebElement element) {
        waitForElementVisible(Platform.ANDROID, element);
        return element.isDisplayed();
    }

    public boolean isUsernameFieldDisplayed() {
        return isElementDisplayed(usernameField);
    }

    public boolean isPasswordFieldDisplayed() {
        return isElementDisplayed(passwordField);
    }

    public boolean isLoginButtonDisplayed() {
        return isElementDisplayed(loginButton);
    }
}
