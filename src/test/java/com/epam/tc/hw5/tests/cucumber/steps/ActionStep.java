package com.epam.tc.hw5.tests.cucumber.steps;

import com.epam.tc.hw5.tests.cucumber.context.TestContext;
import com.epam.tc.hw5.utils.TestUsersProviderUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class ActionStep extends AbstractStep {

    @When("I click on {string} checkbox")
    @Step("Click Checkbox with name {text} on Elements page")
    public void clickElementCheckBoxWithText(String text) {
        TestContext.getInstance().addTestObjectInList("checkboxes", text);
        elementsPage.clickElementsCheckBoxWithText(text);
    }

    @When("I click on {string} radio")
    @Step("Click Radio with name {text} on Elements page")
    public void clickElementsRadioWithText(String text) {
        TestContext.getInstance().addTestObject("radio", text);
        elementsPage.clickElementsRadioWithText(text);
    }

    @When("I choose {string} color in dropdown list")
    @Step("Choose {color} color in Dropdown Menu on Elements page")
    public void chooseColorDropdownMenu(String color) {
        TestContext.getInstance().addTestObject("dropdown-color", color);
        elementsPage.chooseColorDropdownMenu(color);
    }

    @When("I select 'vip' checkbox for {string}")
    @Step("select VIP checkbox on User Table page")
    public void selectVipCheckBox(String username) {
        userTable.table.setVip(username);
    }

    @Step("Switch to frame containing Button")
    public void switchToButtonFrame() {
        homePage.switchToButtonFrame();
    }

    @Step("Switch to parent frame")
    public void switchToParentFrame() {
        homePage.switchToParentFrame();
    }
}
