package com.epam.tc.hw3.bonus.fluent.pages;

import com.epam.tc.hw3.pages.AbstractPageObject;
import com.epam.tc.hw3.pages.components.homepage.HomePageBenefitsContainer;
import com.epam.tc.hw3.pages.components.homepage.HomePageButtonIFrame;
import com.epam.tc.hw3.pages.components.homepage.HomePageLoginMenu;
import com.epam.tc.hw3.pages.components.homepage.HomePageNavigationBar;
import com.epam.tc.hw3.pages.components.homepage.HomePageSidebar;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

public class FluentHomePageObject extends AbstractPageObject {


    private HomePageLoginMenu loginMenu;
    private HomePageNavigationBar navigationBar;
    private HomePageBenefitsContainer benefitsContainer;
    private HomePageButtonIFrame buttonIFrame;
    private HomePageSidebar sidebar;


    public FluentHomePageObject(WebDriver driver) {
        super(driver);
        loginMenu = new HomePageLoginMenu(driver);
        navigationBar = new HomePageNavigationBar(driver);
        benefitsContainer = new HomePageBenefitsContainer(driver);
        buttonIFrame = new HomePageButtonIFrame(driver);
        sidebar = new HomePageSidebar(driver);
    }

    public FluentHomePageObject checkTitle(String title) {
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(title);
        return this;
    }


    public FluentHomePageObject signIn(String login, String password) {
        loginMenu.signIn(login, password);
        return this;
    }

    public FluentHomePageObject checkSignIn(String expectedUserName) {
        Assertions.assertThat(loginMenu.getUserNameText().isDisplayed()).isTrue();
        Assertions.assertThat(loginMenu.getUserNameText().getText()).isEqualTo(expectedUserName);
        return this;
    }

    public FluentHomePageObject checkNavigationItemsQuantity(int expectedNumber) {
        Assertions.assertThat(navigationBar.getNavigationBarItemsQuantity()).isEqualTo(expectedNumber);
        return this;
    }

    public FluentHomePageObject checkIconsNumber(int expectedNumber) {
        Assertions.assertThat(benefitsContainer.getBenefitsIconsQuantity()).isEqualTo(expectedNumber);
        return this;
    }

    public FluentHomePageObject checkBenefitTexts(List<String> expectedBenefitTexts) {
        Assertions.assertThat(benefitsContainer.getBenefitTextsExtracted()).isEqualTo(expectedBenefitTexts);
        return this;
    }

    public FluentHomePageObject checkIfButtonFrameDisplayed() {
        Assertions.assertThat(buttonIFrame.getButtonIFrame().isDisplayed()).isTrue();
        return this;
    }

    public FluentHomePageObject switchToButtonFrame() {
        webDriver.switchTo().frame(buttonIFrame.getButtonIFrame());
        return this;
    }

    public FluentHomePageObject checkIfButtonDisplayed() {
        Assertions.assertThat(buttonIFrame.getButton().isDisplayed()).isTrue();
        return this;
    }

    public FluentHomePageObject switchToParentFrame() {
        webDriver.switchTo().parentFrame();
        return this;
    }

    public FluentHomePageObject checkSidebarElements(List<String> expectedSidebarElements) {
        Assertions.assertThat(sidebar.getSidebarElementsExtracted()).isEqualTo(expectedSidebarElements);
        return this;
    }

    public FluentHomePageObject clickNavigationItemWithIndex(int index) {
        navigationBar.clickItemWithIndex(index);
        return this;
    }

    public FluentDifferentElementsPageObject clickRefDifferentElements() {
        navigationBar.clickRefDifferentElements();
        return new FluentDifferentElementsPageObject(webDriver);
    }

}
