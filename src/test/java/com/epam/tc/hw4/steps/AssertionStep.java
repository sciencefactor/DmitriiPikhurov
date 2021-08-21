package com.epam.tc.hw4.steps;

import io.qameta.allure.Step;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;

public class AssertionStep extends AbstractStep {
   
    public AssertionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Check if all User actions on this page was written on logs panel")
    public void checkIfLogsListPanelCorrect(Map<String, String> expectedLogs) {
        elementsPage.checkIfLogsListPanelCorrect(expectedLogs);
    }

    @Step("Check if Use logged in")
    public void checkLogIn(String expectedUserName) {
        homePage.checkLogIn(expectedUserName);
    }

    @Step("Check if page has correct title")
    public void checkTitle(String expectedPageTitle) {
        homePage.checkTitle(expectedPageTitle);
    }

    @Step("Check if quantity of navigation items is correct")
    public void checkNavigationItemsQuantity(int expectedNumber) {
        homePage.checkNavigationItemsQuantity(expectedNumber);
    }

    @Step("Check if quantity of Benefit icons is correct")
    public void checkIconsNumber(int expectedNumber) {
        homePage.checkIconsNumber(expectedNumber);
    }

    @Step("Check if Benefit Texts are correct")
    public void checkBenefitTexts(List<String> expectedTexts) {
        homePage.checkBenefitTexts(expectedTexts);
    }

    @Step("Check if page has Button iframe")
    public void checkIfButtonFrameDisplayed() {
        homePage.checkIfButtonFrameDisplayed();
    }

    @Step("Check if button in Button iframe is shown")
    public void checkIfButtonDisplayed() {
        homePage.checkIfButtonDisplayed();
    }

    @Step("Check correctness of sidebar elements")
    public void checkSidebarElements(List<String> expectedSideBarElements) {
        homePage.checkSidebarElements(expectedSideBarElements);
    }
}
