package com.epam.tc.hw6.driver;


import java.util.Objects;
import org.openqa.selenium.WebDriver;

public class WebDriverProvider {
    private static WebDriver webDriver;

    private WebDriverProvider() {
    }

    public static WebDriver getDriver(){
        String driverType = System.getProperty("driver.type", "local");
        String browserName = System.getProperty("browser.name", "firefox");
        if (Objects.isNull(webDriver)){
            webDriver = WebDriverFactory.createWebDriver(driverType, browserName);
        }
        return webDriver;
    }

    public static void closeBrowser(){
        webDriver.quit();
        webDriver = null;
    }
}
