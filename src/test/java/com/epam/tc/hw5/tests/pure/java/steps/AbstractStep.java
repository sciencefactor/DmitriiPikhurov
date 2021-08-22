package com.epam.tc.hw5.tests.pure.java.steps;

import com.epam.tc.hw5.pages.DifferentElementsPageObject;
import com.epam.tc.hw5.pages.HomePageObject;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected HomePageObject homePage;
    protected DifferentElementsPageObject elementsPage;

    protected AbstractStep(WebDriver webDriver) {
        homePage = new HomePageObject(webDriver);
        elementsPage = new DifferentElementsPageObject(webDriver);
    }

}
