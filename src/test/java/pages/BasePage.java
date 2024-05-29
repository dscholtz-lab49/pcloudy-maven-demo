package pages;

import drivers.AndroidDriverManager;
import drivers.IOSDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected AndroidDriverManager androidDriverManager;
    protected IOSDriverManager iosDriverManager;

    public BasePage(AndroidDriverManager androidDriverManager) {
        this.androidDriverManager = androidDriverManager;
    }

    public void waitForElementVisible(Platform platformName, WebElement element) {
        if (platformName.is (Platform.ANDROID)) {
            WebDriverWait wait = new WebDriverWait(androidDriverManager.getDriver(), 5);
            wait.until(ExpectedConditions.visibilityOf(element));
        } else if (platformName.is (Platform.IOS)) {
            WebDriverWait wait = new WebDriverWait(iosDriverManager.getDriver(), 5);
            wait.until(ExpectedConditions.visibilityOf(element));
        }
    }
}
