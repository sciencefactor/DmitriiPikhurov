package com.epam.tc.hw3.bonus.fluent.tests;

import com.epam.tc.hw3.bonus.fluent.pages.FluentDifferentElementsPageObject;
import com.epam.tc.hw3.bonus.fluent.pages.FluentHomePageObject;
import com.epam.tc.hw3.tests.PagesUITest;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FluentTestElementsPage extends PagesUITest {

    private FluentHomePageObject homePage;
    private FluentDifferentElementsPageObject elementsPage;

    @BeforeClass
    void navigateToHomePage() {
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        homePage = new FluentHomePageObject(webDriver);
    }

    @DataProvider(name = "loginData")
    Object[][] loginData() {
        return new Object[][] {
            {properties.getProperty("username"), properties.getProperty("password"), "ROMAN IOVLEV"}};
    }

    @Test(dataProvider = "loginData")
    void login(String login, String password, String expectedUserName) {
        homePage.signIn(login, password).checkSignIn(expectedUserName);
    }

    @DataProvider(name = "indexOfDropdown")
    Object[][] indexOfDropdown() {
        return new Object[][] {{2}};
    }

    @Test(dependsOnMethods = {"login"}, dataProvider = "indexOfDropdown")
    void switchToElementsPage(int indexOfReference) {
        elementsPage = homePage.clickNavigationItemWithIndex(indexOfReference).clickRefDifferentElements();
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
        elementsPage.clickElementCheckBoxByIndex(indexBoxFirst)
            .clickElementCheckBoxByIndex(indexBoxSecond)
            .clickElementsRadioByIndex(indexRadio)
            .chooseColorDropdownMenu(color)
            .checkIfLogsListPanelCorrect(expectedLogs);
    }


}
