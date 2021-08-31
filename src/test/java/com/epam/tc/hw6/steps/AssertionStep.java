package com.epam.tc.hw6.steps;

import io.qameta.allure.Step;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Check if all User actions on this page was written on logs panel")
    public void checkIfLogsListPanelCorrect(Map<String, String> expectedLogs) {
        Assertions.assertThat(elementsPage.getMapOfLogsFromLogPanel()).isEqualTo(expectedLogs);
    }

    @Step("Check if Use logged in")
    public void checkLogIn(String expectedUserName) {
        Assertions.assertThat(homePage.getLogIn().isDisplayed()).isTrue();
        Assertions.assertThat(homePage.getLogIn().getText()).isEqualTo(expectedUserName);
    }

    @Step("Check if page has correct title")
    public void checkTitle(String expectedPageTitle) {
        Assertions.assertThat(homePage.getTitle()).isEqualTo(expectedPageTitle);
    }

    @Step("Check if quantity of navigation items is correct")
    public void checkNavigationItemsQuantity(int expectedNumber) {
        Assertions.assertThat(homePage.getNavigationItemsQuantity()).isEqualTo(expectedNumber);
    }

    @Step("Check if quantity of Benefit icons is correct")
    public void checkIconsNumber(int expectedNumber) {
        Assertions.assertThat(homePage.getIconsNumber()).isEqualTo(expectedNumber);
    }

    @Step("Check if Benefit Texts are correct")
    public void checkBenefitTexts(List<String> expectedTexts) {
        Assertions.assertThat(homePage.getBenefitTexts()).isEqualTo(expectedTexts);
    }

    @Step("Check if page has Button iframe")
    public void checkIfButtonFrameDisplayed() {
        Assertions.assertThat(homePage.getButtonFrame().isDisplayed()).isTrue();
    }

    @Step("Check if button in Button iframe is shown")
    public void checkIfButtonDisplayed() {
        Assertions.assertThat(homePage.getButton().isDisplayed()).isTrue();
    }

    @Step("Check correctness of sidebar elements")
    public void checkSidebarElements(List<String> expectedSideBarElements) {
        Assertions.assertThat(homePage.getSidebarElementsText()).isEqualTo(expectedSideBarElements);
    }
}
