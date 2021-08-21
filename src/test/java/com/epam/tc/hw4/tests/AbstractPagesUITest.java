package com.epam.tc.hw4.tests;

import com.epam.tc.hw4.pages.AbstractPageObject;
import com.epam.tc.hw4.pages.HomePageObject;
import com.epam.tc.hw4.utils.TestUsersProviderUtil;
import com.epam.tc.hw4.utils.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractPagesUITest {

    public WebDriver webDriver;
    public HomePageObject homePage;

    @BeforeClass(description = "Set up WebDriver, navigate to https://jdi-testing.github.io/jdi-light/index.html")
    public void setUp(ITestContext context) {
        webDriver = WebDriverProvider.getChromeDriver();
        context.setAttribute("driver", webDriver);
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        homePage = new HomePageObject(webDriver);
    }

    @BeforeMethod(description = "If not logged in, then login")
    void loginPrecondition() {
        homePage.logIn(TestUsersProviderUtil.getUsernameData(), TestUsersProviderUtil.getPasswordData());
    }

    @AfterClass(description = "Close browser")
    public void closeBrowser() {
        webDriver.quit();
    }
}
