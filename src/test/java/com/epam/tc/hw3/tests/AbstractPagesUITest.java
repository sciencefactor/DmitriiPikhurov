package com.epam.tc.hw3.tests;

import com.epam.tc.hw3.pages.AbstractPageObject;
import com.epam.tc.hw3.utils.LoginUtils;
import com.epam.tc.hw3.utils.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class AbstractPagesUITest {

    public WebDriver webDriver;


    @BeforeClass
    public void setUp() {
        webDriver = WebDriverProvider.getChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }



    protected <T extends AbstractPageObject> void loginPrecondition(T page) {
        page.logIn(LoginUtils.getUsernameData(), LoginUtils.getPasswordData());
    }


    @AfterClass
    public void closeBrowser() {
        webDriver.quit();
    }
}
