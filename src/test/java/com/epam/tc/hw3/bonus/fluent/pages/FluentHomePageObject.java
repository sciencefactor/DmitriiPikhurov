package com.epam.tc.hw3.bonus.fluent.pages;

import com.epam.tc.hw3.pages.PageObject;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FluentHomePageObject extends PageObject {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userNameText;

    @FindBy(css = "ul[class=\"uui-navigation nav navbar-nav m-l8\"]>li")
    private List<WebElement> navigationBarItems;

    @FindBy(css = "span[class^=\"icons-benefit\"]")
    private List<WebElement> benefitIcons;

    @FindBy(css = "span[class=\"benefit-txt\"]")
    private List<WebElement> benefitTexts;

    @FindBy(id = "frame")
    private WebElement buttonFrame;

    @FindBy(id = "frame-button")
    private WebElement inFrameButton;

    @FindBy(css = "ul[class=\"sidebar-menu left\"]>li")
    private List<WebElement> sidebarElements;

    @FindBy(css = "ul[role=\"menu\"]>li>a[href=\"different-elements.html\"]")
    private WebElement refToDifferentElements;


    public FluentHomePageObject(WebDriver driver) {
        super(driver);
    }

    public FluentHomePageObject checkTitle(String title) {
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(title);
        return this;
    }

    public FluentHomePageObject signIn(String login, String password) {
        userIcon.click();
        nameField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
        return this;
    }

    public FluentHomePageObject checkSignIn(String expectedUserName) {
        Assertions.assertThat(userNameText.isDisplayed()).isTrue();
        Assertions.assertThat(userNameText.getText()).isEqualTo(expectedUserName);
        return this;
    }

    public FluentHomePageObject checkNavigationItemsQuantity(int expectedNumber) {
        Assertions.assertThat(navigationBarItems.size()).isEqualTo(expectedNumber);
        return this;
    }

    public FluentHomePageObject checkIconsNumber(int expectedNumber) {
        Assertions.assertThat(benefitIcons.size()).isEqualTo(expectedNumber);
        return this;
    }

    public FluentHomePageObject checkBenefitTexts(List<String> expectedBenefitTexts) {
        List<String> benefitTextsExtracted =
            benefitTexts.stream().map(WebElement::getText).collect(Collectors.toList());
        Assertions.assertThat(benefitTextsExtracted).isEqualTo(expectedBenefitTexts);
        return this;
    }

    public FluentHomePageObject checkIfButtonFrameDisplayed() {
        Assertions.assertThat(buttonFrame.isDisplayed()).isTrue();
        return this;
    }

    public FluentHomePageObject switchToButtonFrame() {
        webDriver.switchTo().frame(buttonFrame);
        return this;
    }

    public FluentHomePageObject checkIfButtonDisplayed() {
        Assertions.assertThat(inFrameButton.isDisplayed()).isTrue();
        return this;
    }

    public FluentHomePageObject switchToParentFrame() {
        webDriver.switchTo().parentFrame();
        return this;
    }

    public FluentHomePageObject checkSidebarElements(List<String> expectedSidebarElements) {
        List<String> sidebarElementsExtracted =
            sidebarElements.stream().map(WebElement::getText).collect(Collectors.toList());
        Assertions.assertThat(sidebarElementsExtracted).isEqualTo(expectedSidebarElements);
        return this;
    }

    public FluentHomePageObject clickNavigationItemWithIndex(int index) {
        navigationBarItems.get(index).click();
        return this;
    }

    public FluentDifferentElementsPageObject clickRefDifferentElements() {
        refToDifferentElements.click();
        return new FluentDifferentElementsPageObject(webDriver);
    }

}
