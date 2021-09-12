package com.epam.tc.hw6.tests;

import com.epam.tc.hw6.driver.WebDriverProvider;
import com.epam.tc.hw6.steps.ActionStep;
import com.epam.tc.hw6.steps.AssertionStep;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractPagesUITest {

    public WebDriver webDriver;
    protected AssertionStep assertionStep;
    protected ActionStep actionStep;

    @BeforeClass(description = "Set up WebDriver, navigate to https://jdi-testing.github.io/jdi-light/index.html")
    public void setUp(ITestContext context) {
        webDriver = WebDriverProvider.getDriver();
        webDriver.manage().window().maximize();
        assertionStep = new AssertionStep(webDriver);
        actionStep = new ActionStep(webDriver);
        actionStep.openHomePage();
        context.setAttribute("driver", webDriver);
    }

    @BeforeMethod
    public void login() {
        actionStep.login();
    }

    @AfterClass(description = "Close browser")
    public void closeBrowser() {
        WebDriverProvider.closeBrowser();
    }
}