package com.epam.tc.hw3.bonus.fluent.tests;

import com.epam.tc.hw3.pages.fluent.FluentDifferentElementsPageObject;
import com.epam.tc.hw3.pages.fluent.FluentHomePageObject;
import com.epam.tc.hw3.tests.AbstractPagesUITest;
import com.epam.tc.hw3.utils.PagesDataProviders;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FluentTestElementsPage extends AbstractPagesUITest {

    private FluentHomePageObject homePage;
    private FluentDifferentElementsPageObject elementsPage;

    @BeforeClass
    void navigateToHomePage() {
        homePage = new FluentHomePageObject(webDriver);
        loginPrecondition(homePage);
    }


    @Test(dataProvider = "userName", dataProviderClass = PagesDataProviders.class)
    void checkLogin(String expectedUserName) {
        homePage.checkLogIn(expectedUserName);
    }


    @Test(dataProvider = "elementsPageExpectedLogs", dataProviderClass = PagesDataProviders.class)
    void switchToElementsPage(int indexOfReference,
                              int indexBoxFirst,
                              int indexBoxSecond,
                              int indexRadio,
                              String color,
                              Map<String, String> expectedLogs) {
        elementsPage = homePage.clickNavigationItemWithIndex(indexOfReference).clickRefDifferentElements();
        elementsPage.clickElementCheckBoxWithIndex(indexBoxFirst)
            .clickElementCheckBoxWithIndex(indexBoxSecond)
            .clickElementsRadioWithIndex(indexRadio)
            .chooseColorDropdownMenu(color)
            .checkIfLogsListPanelCorrect(expectedLogs);
    }


}
