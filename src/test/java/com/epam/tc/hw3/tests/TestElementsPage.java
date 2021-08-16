package com.epam.tc.hw3.tests;

import com.epam.tc.hw3.pages.DifferentElementsPageObject;
import com.epam.tc.hw3.pages.HomePageObject;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestElementsPage extends PagesUITest {

    private HomePageObject homePage;
    private DifferentElementsPageObject elementsPage;

    @BeforeClass
    void navigateToHomePage() {
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        homePage = new HomePageObject(webDriver);
    }

    @DataProvider(name = "loginData")
    Object[][] loginData() {
        return new Object[][] {
            {properties.getProperty("username"), properties.getProperty("password"), "ROMAN IOVLEV"}};
    }

    @Test(dataProvider = "loginData")
    void login(String login, String password, String expectedUserName) {
        homePage.signIn(login, password);
        homePage.checkSignIn(expectedUserName);
    }

    @DataProvider(name = "indexOfDropdown")
    Object[][] indexOfDropdown() {
        return new Object[][] {{2}};
    }

    @Test(dependsOnMethods = {"login"}, dataProvider = "indexOfDropdown")
    void switchToElementsPage(int indexOfReference) {
        homePage.clickNavigationItemWithIndex(indexOfReference);
        homePage.clickRefDifferentElements();
        elementsPage = new DifferentElementsPageObject(webDriver);
    }

    @DataProvider(name = "expectedLogs")
    Object[][] expectedLogs() {
        return new Object[][] {{0, 2, 3, "Yellow", Map.of(
            "Water", "true",
            "Wind", "true",
            "metal", "Selen",
            "Colors", "Yellow")}};
    }

    @Test(dependsOnMethods = {"switchToElementsPage"}, dataProvider = "expectedLogs")
    void checkLogPanelList(int indexBoxFirst,
                           int indexBoxSecond,
                           int indexRadio,
                           String color,
                           Map<String, String> expectedLogs) {
        elementsPage.clickElementCheckBoxByIndex(indexBoxFirst);
        elementsPage.clickElementCheckBoxByIndex(indexBoxSecond);
        elementsPage.clickElementsRadioByIndex(indexRadio);
        elementsPage.chooseColorDropdownMenu(color);
        elementsPage.checkIfLogsListPanelCorrect(expectedLogs);
    }


}
