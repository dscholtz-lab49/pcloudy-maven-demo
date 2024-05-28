package stepDefinitions;


import drivers.AndroidDriverManager;
import drivers.IOSDriverManager;
import org.openqa.selenium.Platform;

public class BaseSteps {

    protected AndroidDriverManager androidDriverManager;
    protected IOSDriverManager iosDriverManager;

    public BaseSteps() {
        androidDriverManager = AndroidDriverManager.builder ()
                .platform (Platform.ANDROID)
                .platformVersion ("12.0.0")
                .build ()
                .createAndroidDriver ();
    }

}
