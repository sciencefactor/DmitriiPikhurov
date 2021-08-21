package com.epam.tc.hw4.pages;

import com.epam.tc.hw3.pages.components.homepage.HomePageBenefitsContainer;
import com.epam.tc.hw3.pages.components.homepage.HomePageButtonIFrame;
import com.epam.tc.hw3.pages.components.homepage.HomePageLoginMenu;
import com.epam.tc.hw3.pages.components.homepage.HomePageNavigationBar;
import com.epam.tc.hw3.pages.components.homepage.HomePageSidebar;
import io.qameta.allure.Step;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends AbstractPageObject {


    private HomePageLoginMenu loginMenu;
    private HomePageNavigationBar navigationBar;
    private HomePageBenefitsContainer benefitsContainer;
    private HomePageButtonIFrame buttonIFrame;
    private HomePageSidebar sidebar;


    public HomePageObject(WebDriver driver) {
        super(driver);
        loginMenu = new HomePageLoginMenu(driver);
        navigationBar = new HomePageNavigationBar(driver);
        benefitsContainer = new HomePageBenefitsContainer(driver);
        buttonIFrame = new HomePageButtonIFrame(driver);
        sidebar = new HomePageSidebar(driver);
    }

    public void checkTitle(String title) {
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(title);
    }


    @Override
    public void logIn(String loginData, String passwordData) {
        loginMenu.logIn(loginData, passwordData);
    }

    @Step
    public void checkLogIn(String expectedUserName) {
        Assertions.assertThat(loginMenu.getUserNameText().isDisplayed()).isTrue();
        Assertions.assertThat(loginMenu.getUserNameText().getText()).isEqualTo(expectedUserName);
    }

    @Step
    public void checkNavigationItemsQuantity(int expectedNumber) {
        Assertions.assertThat(navigationBar.getNavigationBarItemsQuantity()).isEqualTo(expectedNumber);
    }

    @Step
    public void checkIconsNumber(int expectedNumber) {
        Assertions.assertThat(benefitsContainer.getBenefitsIconsQuantity()).isEqualTo(expectedNumber);
    }

    @Step
    public void checkBenefitTexts(List<String> expectedBenefitTexts) {
        Assertions.assertThat(benefitsContainer.getBenefitTextsExtracted()).isEqualTo(expectedBenefitTexts);
    }

    @Step
    public void checkIfButtonFrameDisplayed() {
        Assertions.assertThat(buttonIFrame.getButtonIFrame().isDisplayed()).isTrue();
    }

    @Step
    public void switchToButtonFrame() {
        webDriver.switchTo().frame(buttonIFrame.getButtonIFrame());
    }

    @Step
    public void checkIfButtonDisplayed() {
        Assertions.assertThat(buttonIFrame.getButton().isDisplayed()).isTrue();
    }

    @Step
    public void switchToParentFrame() {
        webDriver.switchTo().parentFrame();
    }

    @Step
    public void checkSidebarElements(List<String> expectedSidebarElements) {
        Assertions.assertThat(sidebar.getSidebarElementsExtracted()).isEqualTo(expectedSidebarElements);
    }

    @Step
    public void clickNavigationItemWithIndex(int index) {
        navigationBar.clickItemWithIndex(index);
    }

    @Step
    public void clickRefDifferentElements() {
        navigationBar.clickRefDifferentElements();
    }

}
