package com.epam.tc.hw5.tests.cucumber.steps;

import com.epam.tc.hw5.utils.TestUsersProviderUtil;
import io.cucumber.java.en.Given;
import io.qameta.allure.Step;

public class PreconditionStep extends AbstractStep {

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
}
