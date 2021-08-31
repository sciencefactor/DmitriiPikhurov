package com.epam.tc.hw5.tests.cucumber.steps;

import io.cucumber.datatable.DataTable;
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

    @Then("{string} page should be opened")
    @Step("Correct page should be opened")
    public void correctPageOpened(String pageName) {
        Assertions.assertThat(userTable.getTitle()).isEqualToIgnoringCase(pageName);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    @Step("Correct number of dropdowns")
    public void correctNumberOfDropdowns(int number) {
        Assertions.assertThat(userTable.table.dropdowns.size()).isEqualTo(number);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    @Step("Correct number of usernames")
    public void correctNumberOfUsernames(int number) {
        Assertions.assertThat(userTable.table.names.size()).isEqualTo(number);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    @Step("Correct number of descriptions")
    public void correctNumberOfDescriptions(int number) {
        Assertions.assertThat(userTable.table.descriptions.size()).isEqualTo(number);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    @Step("Correct number of checkboxes")
    public void correctNumberOfCheckboxes(int number) {
        Assertions.assertThat(userTable.table.checkboxes.size()).isEqualTo(number);
    }

    @Then("droplist should contain values in column Type for user Roman")
    @Step("droplist should contain correct values in column Type for user Roman")
    public void correctDropdownValues(DataTable dataTable) {
        Assertions.assertThat(userTable.table.getDropdownOptions()).hasSameElementsAs(dataTable.asList());
    }

    @Then("User table should contain following values:")
    @Step("User table should contain correct values")
    public void userTableShouldContainValues(DataTable dataTable) {
        List<Map<String, String>> expectedRows = dataTable.asMaps(String.class, String.class);
        List<Map<String, String>> actualRows = userTable.table.getListMapOfUsers(expectedRows);
        Assertions.assertThat(actualRows).hasSameElementsAs(expectedRows);
    }

    @Then("1 log row has {string} text in log section")
    @Step("log row has \"Vip: condition changed to true\" text in log section")
    public void logPanelShouldContainVipCondition(String log) {
        Assertions.assertThat(userTable.getLogsList()).contains(log);
    }

}
