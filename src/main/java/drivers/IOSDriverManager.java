package drivers;

import io.appium.java_client.ios.IOSDriver;
import lombok.Builder;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Builder
public class IOSDriverManager {

    public Platform platform;
    public String   platformVersion;

    private IOSDriver driver;

    public IOSDriverManager createIOSDriver () {
        try {
            driver = new IOSDriver (new URL("https://lab.pcloudy.com/appiumcloud/wd/hub"), capabilities ());
            setupDriverTimeouts ();
        } catch (MalformedURLException e) {
            throw new RuntimeException (e);
        }
        return this;
    }

    public IOSDriver getDriver () {
        return driver;
    }

    private void setupDriverTimeouts () {
        getDriver ().manage ()
                .timeouts ()
                .implicitlyWait (30, TimeUnit.SECONDS);
    }

    public void quitDriver () {
        driver.quit ();
    }

    private DesiredCapabilities capabilities () {

        DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability ("pCloudy_Username", "daniel.scholtz@lab49.com");
        capabilities.setCapability ("pCloudy_ApiKey", "mmrr57nt2wxmxtkq6mmg29c4");
        capabilities.setCapability("pCloudy_DurationInMinutes", 10);
        capabilities.setCapability("newCommandTimeout", 600);
        capabilities.setCapability("launchTimeout", 90000);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("pCloudy_DeviceManufacturer", "APPLE");
        capabilities.setCapability("pCloudy_DeviceVersion", "14.0.1");
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("platformName", platform);
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("pCloudy_ApplicationName", "pCloudy_Appium_Demo_Resigned1675160846.ipa");
        capabilities.setCapability("appPackage", "com.pcloudy.appiumdemo");
        capabilities.setCapability("appActivity", "com.ba.mobile.LaunchActivity");
        capabilities.setCapability("pCloudy_WildNet", "false");
        capabilities.setCapability("pCloudy_EnableVideo", "true");
        capabilities.setCapability("pCloudy_EnablePerformanceData", "false");
        capabilities.setCapability("pCloudy_EnableDeviceLogs", "true");
        return capabilities;
    }
}
