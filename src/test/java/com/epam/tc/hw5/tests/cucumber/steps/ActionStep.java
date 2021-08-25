package com.epam.tc.hw5.tests.cucumber.steps;


import com.epam.tc.hw5.tests.cucumber.context.TestContext;
import com.epam.tc.hw5.utils.TestUsersProviderUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;


public class ActionStep extends AbstractStep {


    @Given("User opens Gdi Home page")
    @Step("Open Home Page site")
    public void openHomePage() {
        homePage.openSite();
    }

    @Given("User login")
    @Step("Login")
    public void login() {
        homePage.logIn(TestUsersProviderUtil.getUsernameData(), TestUsersProviderUtil.getPasswordData());
    }

    @Given("User navigate to Different Elements Page")
    @Step("Go to Elements Page via Service header element")
    public void navigateToElementsPage() {
        homePage.clickNavigationItemService();
        homePage.clickRefDifferentElements();
    }

    @When("User clicks on {string} checkbox")
    @Step("Click Checkbox with name {text}")
    public void clickElementCheckBoxWithText(String text) {
        TestContext.getInstance().addTestObjectInList("checkboxes", text);
        elementsPage.clickElementsCheckBoxWithText(text);
    }

    @When("User clicks on {string} radio")
    @Step("Click Radio with name {text}")
    public void clickElementsRadioWithText(String text) {
        TestContext.getInstance().addTestObject("radio", text);
        elementsPage.clickElementsRadioWithText(text);
    }

    @When("User choose {string} color in dropdown list")
    @Step("Choose {color} color in Dropdown Menu")
    public void chooseColorDropdownMenu(String color) {
        TestContext.getInstance().addTestObject("dropdown-color", color);
        elementsPage.chooseColorDropdownMenu(color);
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
