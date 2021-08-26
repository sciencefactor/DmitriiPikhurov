package com.epam.tc.hw5.tests.cucumber.steps;

import com.epam.tc.hw5.tests.cucumber.context.TestContext;
import com.epam.tc.hw5.utils.TestUsersProviderUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class ActionStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    @Step("Open Home Page site")
    public void openHomePage() {
        homePage.openSite();
    }

    @Given("I login as user \"Roman Iovlev\"")
    @Step("Login")
    public void login() {
        homePage.logIn(TestUsersProviderUtil.getUsernameData(), TestUsersProviderUtil.getPasswordData());
    }

    @Given("I navigate to Different Elements Page")
    @Step("Go to Elements Page via Service header element")
    public void navigateToElementsPage() {
        homePage.clickNavigationItemService();
        homePage.clickRefDifferentElements();
    }

    @Given("I click on \"Service\" button in Header")
    @Step("Click on \"Service\" button on Home page")
    public void clickServiceButton() {
        homePage.clickNavigationItemService();
    }

    @Given("I click on {string} button in Service dropdown")
    @Step("Click on button in Service dropdown on Home Page")
    public void clickHeaderButton(String pageName) {
        homePage.clickHeaderUserTableButton(pageName);
    }

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
