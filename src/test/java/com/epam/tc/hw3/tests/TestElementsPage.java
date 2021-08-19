package com.epam.tc.hw3.tests;

import com.epam.tc.hw3.pages.DifferentElementsPageObject;
import com.epam.tc.hw3.pages.HomePageObject;
import com.epam.tc.hw3.utils.PagesDataProviders;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestElementsPage extends AbstractPagesUITest {

    private DifferentElementsPageObject elementsPage;


    @Test(dependsOnMethods = {
        "login"}, dataProvider = "homePageIndexOfDropdown", dataProviderClass = PagesDataProviders.class)
    void switchToElementsPage(int indexOfReference) {
        homePage.clickNavigationItemWithIndex(indexOfReference);
        homePage.clickRefDifferentElements();
        elementsPage = new DifferentElementsPageObject(webDriver);
    }


    @Test(dependsOnMethods = {"switchToElementsPage"},
        dataProvider = "elementsPageExpectedLogs",
        dataProviderClass = PagesDataProviders.class)
    void checkLogPanelList(int indexBoxFirst,
                           int indexBoxSecond,
                           int indexRadio,
                           String color,
                           Map<String, String> expectedLogs) {
        elementsPage.clickElementCheckBoxWithIndex(indexBoxFirst);
        elementsPage.clickElementCheckBoxWithIndex(indexBoxSecond);
        elementsPage.clickElementsRadioWithIndex(indexRadio);
        elementsPage.chooseColorDropdownMenu(color);
        elementsPage.checkIfLogsListPanelCorrect(expectedLogs);
    }


}
