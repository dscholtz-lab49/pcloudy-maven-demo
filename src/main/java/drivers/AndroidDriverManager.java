package drivers;

import io.appium.java_client.android.AndroidDriver;
import lombok.Builder;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Builder
public class AndroidDriverManager {

    public Platform platform;
    public String   platformVersion;

    private AndroidDriver driver;

    public AndroidDriverManager createAndroidDriver () {
        try {
            driver = new AndroidDriver (new URL("https://lab.pcloudy.com/appiumcloud/wd/hub"), capabilities ());
            setupDriverTimeouts ();
        } catch (MalformedURLException e) {
            throw new RuntimeException (e);
        }
        return this;
    }

    public AndroidDriver getDriver () {
        return driver;
    }

    public void quitDriver () {
        driver.quit ();
    }

    private void setupDriverTimeouts () {
        getDriver ().manage ()
                .timeouts ()
                .implicitlyWait (30, TimeUnit.SECONDS);
    }

    private DesiredCapabilities capabilities () {

        DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability ("pCloudy_Username", "daniel.scholtz@lab49.com");
        capabilities.setCapability ("pCloudy_ApiKey", "mmrr57nt2wxmxtkq6mmg29c4");
        capabilities.setCapability ("pCloudy_DurationInMinutes", 10);
        capabilities.setCapability ("newCommandTimeout", 600);
        capabilities.setCapability ("launchTimeout", 90000);
        capabilities.setCapability ("autoGrantPermissions", true);
        capabilities.setCapability("pCloudy_DeviceManufacturer", "GOOGLE");
        capabilities.setCapability("pCloudy_DeviceVersion", "14.0.0");
        capabilities.setCapability ("platformVersion", platformVersion);
        capabilities.setCapability ("platformName", platform);
        capabilities.setCapability ("automationName", "uiautomator2");
        capabilities.setCapability ("pCloudy_ApplicationName", "ExpenseAppVer.apk");
        capabilities.setCapability ("appPackage", "io.perfecto.expense.tracker");
        capabilities.setCapability ("appActivity", "app.perfecto.com.expencemanager.ui.splash.SplashActivity");
        capabilities.setCapability ("pCloudy_WildNet", "false");
        capabilities.setCapability ("pCloudy_EnableVideo", "true");
        capabilities.setCapability ("pCloudy_EnablePerformanceData", "false");
        capabilities.setCapability ("pCloudy_EnableDeviceLogs", "true");
        capabilities.setCapability ("pCloudy_screenShotOnError", "true");
        return capabilities;
    }
}
