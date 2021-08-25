package com.epam.tc.hw5.tests.cucumber.steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;

public class AssertionStep extends AbstractStep {

    @ParameterType("'(.+)'")
    public Map<String, String> expectedLogs(String logs) {
        return Arrays.stream(logs.split(","))
              .map(String::trim)
              .map(pair -> pair.split("="))
              .collect(Collectors.toMap(a -> a[0], a -> a[1]));
    }

    @Then("All actions should be visible on Logs panel: {expectedLogs}")
    @Step("Check if all User actions on this page was written on logs panel")
    public void allInteractionWithPageShouldBeVisibleOnLogPanel(Map<String, String> expectedLogs) {
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
