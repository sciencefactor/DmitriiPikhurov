package com.epam.tc.hw6.steps;

import com.epam.tc.hw6.pages.DifferentElementsPageObject;
import com.epam.tc.hw6.pages.HomePageObject;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected HomePageObject homePage;
    protected DifferentElementsPageObject elementsPage;

    protected AbstractStep(WebDriver webDriver) {
        homePage = new HomePageObject(webDriver);
        elementsPage = new DifferentElementsPageObject(webDriver);
    }

}
