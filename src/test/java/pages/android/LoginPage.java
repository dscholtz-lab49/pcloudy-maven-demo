package pages.android;

import drivers.AndroidDriverManager;
import io.appium.java_client.MobileBy;

public class LoginPage {

    private AndroidDriverManager androidDriverManager;

    public LoginPage(AndroidDriverManager androidDriverManager) {
        this.androidDriverManager = androidDriverManager;
    }

    public boolean isUsernameFieldDisplayed() {
        return androidDriverManager.getDriver().findElement(MobileBy.id("io.perfecto.expense.tracker:id/login_email")).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return androidDriverManager.getDriver().findElement(MobileBy.id("io.perfecto.expense.tracker:id/login_password")).isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return androidDriverManager.getDriver().findElement(MobileBy.id("io.perfecto.expense.tracker:id/login_login_btn")).isDisplayed();
    }
}
