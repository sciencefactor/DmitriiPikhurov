package com.epam.tc.hw6.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;
import javax.management.openmbean.InvalidOpenTypeException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {

    private WebDriverFactory() {
    }

    private static final String REMOTE_TYPE = "remote";
    private static final String LOCAL_TYPE = "local";
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String HUB_URL = "http://192.168.0.102:4444/wd/hub";

    public static WebDriver createWebDriver(String type, String browserName) {
        if (type.equalsIgnoreCase(REMOTE_TYPE)) {
            return createRemoteDriver(browserName);
        } else if (type.equalsIgnoreCase(LOCAL_TYPE)) {
            return createLocalDriver(browserName);
        } else {
            throw new IllegalArgumentException(String.format("Wrong driver type: %s", type));
        }
    }

    private static WebDriver createRemoteDriver(String browserName) {
        Capabilities capabilities;
        if (browserName.equalsIgnoreCase(CHROME)) {
            capabilities = createChromeCapabilities();
        } else if (browserName.equalsIgnoreCase(FIREFOX)) {
            capabilities = createFirefoxCapabilities();
        } else {
            throw new IllegalArgumentException(String.format("Wrong browser name: %s", browserName));
        }
        return tryGetRemoteWebDriver(capabilities);
    }

    private static RemoteWebDriver tryGetRemoteWebDriver(Capabilities capabilities) {
        try {
            return new RemoteWebDriver(new URL(HUB_URL), Objects.requireNonNull(capabilities));
        } catch (MalformedURLException e) {
            throw new InvalidOpenTypeException(String.format("Invalid Selenium hub URL: %s", HUB_URL));
        }
    }

    private static Capabilities createChromeCapabilities() {
        return new ChromeOptions();
    }

    private static Capabilities createFirefoxCapabilities() {
        return new FirefoxOptions();
    }

    private static WebDriver createLocalDriver(String browserName) {
        if (browserName.equalsIgnoreCase(CHROME)) {
            return createChromeDriver();
        } else if (browserName.equalsIgnoreCase(FIREFOX)) {
            return createFirefoxDriver();
        } else {
            throw new IllegalArgumentException(String.format("Wrong browser name: %s", browserName));
        }
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return webDriver;
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return webDriver;
    }
}
