package com.epam.tc.hw3.bonus.fluent.tests;

import com.epam.tc.hw3.bonus.fluent.pages.FluentDifferentElementsPageObject;
import com.epam.tc.hw3.bonus.fluent.pages.FluentHomePageObject;
import com.epam.tc.hw3.tests.AbstractPagesUITest;
import com.epam.tc.hw3.utils.PagesDataProviders;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FluentTestElementsPageAbstract extends AbstractPagesUITest {

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
