package com.epam.tc.hw4.tests;

import com.epam.tc.hw4.pages.DifferentElementsPageObject;
import com.epam.tc.hw4.utils.PagesDataProviders;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.Map;
import org.testng.annotations.Test;

@Feature("Logs Panel shows all user action")
@Story("User need to check all his actions on current page")
public class TestElementsPageLogsPanel extends AbstractPagesUITest {

    private DifferentElementsPageObject elementsPage;


    @Test(dataProvider = "userName",
          dataProviderClass = PagesDataProviders.class,
          description = "User must be logged in")
    void checkLogin(String expectedUserName) {
        homePage.checkLogIn(expectedUserName);
    }

    @Test(dataProvider = "elementsPageExpectedLogs",
          dataProviderClass = PagesDataProviders.class,
          description = "Logs container must show all interactions on the page")
    void checkElementsPageLogPanel(int indexOfReference,
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
