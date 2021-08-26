package com.epam.tc.hw5.tests.cucumber.hooks;

import com.epam.tc.hw5.tests.cucumber.context.TestContext;
import com.epam.tc.hw5.utils.WebDriverProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CucumberHook {

    private WebDriver webDriver;

    @Before
    public void initDriver() {
        webDriver = WebDriverProvider.getChromeDriver();
        webDriver.manage().window().maximize();
        TestContext.getInstance().addTestObject("driver", webDriver);
    }

    @After
    public void closeBrowser() {
        webDriver.quit();
    }
}
