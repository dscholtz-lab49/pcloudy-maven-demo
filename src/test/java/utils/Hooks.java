package utils;

import drivers.AndroidDriverManager;
import drivers.IOSDriverManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.Platform;

public class Hooks {

    public static AndroidDriverManager androidDriverManager;
    public static IOSDriverManager iosDriverManager;

    @BeforeAll
    public static void setUp() {
        androidDriverManager = AndroidDriverManager.builder ()
                .platform (Platform.ANDROID)
                .platformVersion ("12.0.0")
                .build ()
                .createAndroidDriver ();
    }


    @AfterAll()
    public static void tearDown () {
        if (androidDriverManager != null) {
            androidDriverManager.quitDriver();
        } else if (iosDriverManager != null) {
            iosDriverManager.quitDriver();
        }
    }
}
