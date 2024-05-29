package pages.web;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class HomePage extends BasePage {

    @FindBy(xpath = "(//div[contains(@class, 'top-menu')]//a[contains(text(), 'Personal')])[1]")
    private WebElement personalMenu;

    @FindBy(xpath = "(//div[contains(@class, 'top-menu')]//a[contains(text(), 'Business')])[1]")
    private WebElement businessMenu;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isElementDisplayed(WebElement element) {
        waitForElementVisible(Platform.WINDOWS, element);
        return element.isDisplayed();
    }

    public boolean isPersonalMenuDisplayed() {
        return isElementDisplayed(personalMenu);
    }

    public boolean isBusinessMenuDisplayed() {
        return isElementDisplayed(businessMenu);
    }
}
