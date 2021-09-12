package com.epam.tc.gdi.hw1.tests;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.gdi.hw1.site.pages.JdiTestSite;
import com.epam.tc.gdi.hw1.tests.steps.Preconditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestsInit {

    @BeforeSuite
    void setUp() {
        PageFactory.initElements(JdiTestSite.class);
        JdiTestSite.homePage.open();
    }

    @BeforeMethod
    void loginIfNot() {
        Preconditions.shouldBeLoggedIn();
    }

    @AfterSuite
    void tearDown() {
        WebDriverUtils.killAllSeleniumDrivers();
    }


}
