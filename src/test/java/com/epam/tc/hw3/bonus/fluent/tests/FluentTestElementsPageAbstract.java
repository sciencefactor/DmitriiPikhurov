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
    }


    @Test(dataProvider = "loginData", dataProviderClass = PagesDataProviders.class)
    void login(String login, String password, String expectedUserName) {
        homePage.signIn(login, password).checkSignIn(expectedUserName);
    }


    @Test(dependsOnMethods = {
        "login"}, dataProvider = "homePageIndexOfDropdown", dataProviderClass = PagesDataProviders.class)
    void switchToElementsPage(int indexOfReference) {
        elementsPage = homePage.clickNavigationItemWithIndex(indexOfReference).clickRefDifferentElements();
    }


    @Test(dependsOnMethods = {"switchToElementsPage"},
        dataProvider = "elementsPageExpectedLogs",
        dataProviderClass = PagesDataProviders.class)
    void checkLogPanelList(int indexBoxFirst,
                           int indexBoxSecond,
                           int indexRadio,
                           String color,
                           Map<String, String> expectedLogs) {
        elementsPage.clickElementCheckBoxWithIndex(indexBoxFirst)
            .clickElementCheckBoxWithIndex(indexBoxSecond)
            .clickElementsRadioWithIndex(indexRadio)
            .chooseColorDropdownMenu(color)
            .checkIfLogsListPanelCorrect(expectedLogs);
    }


}
