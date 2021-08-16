package com.epam.tc.hw3.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {
    private static WebDriver webDriver;

    private WebDriverProvider() {
    }

    private static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static WebDriver getChromeDriver() {
        setupChromeDriver();
        return webDriver;
    }
}
