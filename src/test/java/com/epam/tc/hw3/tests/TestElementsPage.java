package com.epam.tc.hw3.tests;

import com.epam.tc.hw3.pages.DifferentElementsPageObject;
import com.epam.tc.hw3.pages.HomePageObject;
import com.epam.tc.hw3.utils.PagesDataProviders;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestElementsPage extends AbstractPagesUITest {

    private DifferentElementsPageObject elementsPage;

    @Test(dataProvider = "userName", dataProviderClass = PagesDataProviders.class)
    void checkLogin(String expectedUserName) {
        homePage.checkLogIn(expectedUserName);
    }


    @Test(dataProvider = "elementsPageExpectedLogs", dataProviderClass = PagesDataProviders.class)
    void checkElementsPageLogMenu(int indexOfReference,
                              int indexBoxFirst,
                              int indexBoxSecond,
                              int indexRadio,
                              String color,
                              Map<String, String> expectedLogs) {
        homePage.clickNavigationItemWithIndex(indexOfReference);
        homePage.clickRefDifferentElements();
        elementsPage = new DifferentElementsPageObject(webDriver);
        elementsPage.clickElementCheckBoxWithIndex(indexBoxFirst);
        elementsPage.clickElementCheckBoxWithIndex(indexBoxSecond);
        elementsPage.clickElementsRadioWithIndex(indexRadio);
        elementsPage.chooseColorDropdownMenu(color);
        elementsPage.checkIfLogsListPanelCorrect(expectedLogs);
    }


}
