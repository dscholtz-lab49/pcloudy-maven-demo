package listener;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;

public class CustomListener extends TestListenerAdapter {
    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getTestContext().getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getTestContext().getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getTestContext().getName());
        //captureScreenshot(driver, result);
    }


    public static String captureScreenshot (WebDriver driver, ITestResult result) {

        try {
            TakesScreenshot ts = (TakesScreenshot)driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = "screenshots/" + result.getTestName() + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
            return dest;
        }

        catch (IOException e) {return e.getMessage();}
    }
}
