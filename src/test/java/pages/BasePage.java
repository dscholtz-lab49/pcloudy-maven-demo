package pages;

import drivers.AndroidDriverManager;
import drivers.IOSDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected AndroidDriverManager androidDriverManager;
    protected IOSDriverManager iosDriverManager;
    protected WebDriver webDriver;
    private static final Duration TIMEOUT = Duration.ofSeconds(5);

    public BasePage(AndroidDriverManager androidDriverManager) {
        this.androidDriverManager = androidDriverManager;
    }

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void waitForElementVisible(Platform platformName, WebElement element) {
        if (platformName.is (Platform.ANDROID)) {
            WebDriverWait wait = new WebDriverWait(androidDriverManager.getDriver(), TIMEOUT);
            wait.until(ExpectedConditions.visibilityOf(element));
        } else if (platformName.is (Platform.IOS)) {
            WebDriverWait wait = new WebDriverWait(iosDriverManager.getDriver(), TIMEOUT);
            wait.until(ExpectedConditions.visibilityOf(element));
        } else if (platformName.is (Platform.WINDOWS)) {
            WebDriverWait wait = new WebDriverWait(webDriver, TIMEOUT);
            wait.until(ExpectedConditions.visibilityOf(element));
        }
    }
}
