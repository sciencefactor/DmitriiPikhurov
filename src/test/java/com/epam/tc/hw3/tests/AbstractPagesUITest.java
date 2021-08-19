package com.epam.tc.hw3.tests;

import com.epam.tc.hw3.pages.HomePageObject;
import com.epam.tc.hw3.utils.PagesDataProviders;
import com.epam.tc.hw3.utils.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public abstract class AbstractPagesUITest {

    public WebDriver webDriver;
    protected HomePageObject homePage;


    @BeforeClass
    public void setUp() {
        webDriver = WebDriverProvider.getChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        homePage = new HomePageObject(webDriver);
    }

    @Test(dataProvider = "loginData", dataProviderClass = PagesDataProviders.class)
    void login(String login, String password) {
        homePage.signIn(login, password);
    }


    @AfterClass
    public void closeBrowser() {
        webDriver.quit();
    }
}
