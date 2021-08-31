package com.epam.tc.hw6.steps;


import com.epam.tc.hw6.utils.TestUsersProviderUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Open Home Page site")
    public void openHomePage() {
        homePage.openSite();
    }

    @Step("Login")
    public void login() {
        homePage.logIn(TestUsersProviderUtil.getUsernameData(), TestUsersProviderUtil.getPasswordData());
    }

    @Step("Go to Elements Page via Service header element")
    public void navigateToElementsPage() {
        homePage.clickNavigationItemService();
        homePage.clickRefDifferentElements();
    }

    @Step("Click Checkbox with name {text}")
    public void clickElementCheckBoxWithText(String text) {
        elementsPage.clickElementsCheckBoxWithText(text);
    }

    @Step("Click Radio with name {text}")
    public void clickElementsRadioWithText(String text) {
        elementsPage.clickElementsRadioWithText(text);
    }

    @Step("Choose {color} color in Dropdown Menu")
    public void chooseColorDropdownMenu(String color) {
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
