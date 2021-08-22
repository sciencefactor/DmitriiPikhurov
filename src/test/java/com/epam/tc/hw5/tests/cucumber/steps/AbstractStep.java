package com.epam.tc.hw5.tests.cucumber.steps;

import com.epam.tc.hw5.pages.DifferentElementsPageObject;
import com.epam.tc.hw5.pages.HomePageObject;
import com.epam.tc.hw5.tests.cucumber.context.TestContext;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected HomePageObject homePage;
    protected DifferentElementsPageObject elementsPage;

    protected AbstractStep() {
        WebDriver webDriver = TestContext.getInstance().getObject("driver");
        homePage = new HomePageObject(webDriver);
        elementsPage = new DifferentElementsPageObject(webDriver);
    }

}
