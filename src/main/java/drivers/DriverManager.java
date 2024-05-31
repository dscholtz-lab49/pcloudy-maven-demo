package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.service.DriverFinder;

import java.io.File;
import java.nio.file.Path;

public class DriverManager {

    private WebDriver driver;
    protected File driverPath;
    protected File browserPath;

    public WebDriver createAndroidDriver(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();

                chromeOptions.setBrowserVersion("stable");
                chromeOptions.addArguments("--window-size=1920,1080");
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");

                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                firefoxOptions.addArguments("-headless");
                firefoxOptions.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");

                //options.setBinary(getFirefoxLocation());

                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type: " + browserType);
        }
        return driver;
    }

    public void setDriverLocation() {
        getChromeLocation();
        ChromeOptions options = new ChromeOptions();
        options.setBinary(browserPath);

        ChromeDriverService service =
                new ChromeDriverService.Builder().usingDriverExecutable(driverPath).build();

        driver = new ChromeDriver(service, options);
    }


    private void getChromeLocation() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("stable");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");
        DriverFinder finder = new DriverFinder(ChromeDriverService.createDefaultService(), chromeOptions);
        driverPath = new File(finder.getDriverPath());
        browserPath = new File(finder.getBrowserPath());
    }

    private Path getFirefoxLocation() {
        FirefoxOptions options = new FirefoxOptions();
        options.setBrowserVersion("stable");
        DriverFinder finder = new DriverFinder(GeckoDriverService.createDefaultService(), options);
        return Path.of(finder.getBrowserPath());
    }
}
