package com.epam.tc.hw3.bonus.fluent.tests;


import com.epam.tc.hw3.bonus.fluent.pages.FluentHomePageObject;
import com.epam.tc.hw3.tests.AbstractPagesUITest;
import com.epam.tc.hw3.utils.PagesDataProviders;
import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FluentTestHomePageControlElementsAbstract extends AbstractPagesUITest {

    private FluentHomePageObject homePage;


    @BeforeClass
    void navigateToHomePage() {
        homePage = new FluentHomePageObject(webDriver);
        loginPrecondition(homePage);
    }


    @Test(dataProvider = "homePageExpectedPageTitle", dataProviderClass = PagesDataProviders.class)
    void checkHomePageTitle(String expectedPageTitle) {
        homePage.checkTitle(expectedPageTitle);
    }


    @Test(dataProvider = "userName", dataProviderClass = PagesDataProviders.class)
    void checkLogin(String expectedUserName) {
        homePage.checkLogIn(expectedUserName);
    }


    @Test(dataProvider = "homePageExpectedNavigationItemsQuantity",
        dataProviderClass = PagesDataProviders.class)
    void checkNavigationItemsQuantity(int expectedNumber) {
        homePage.checkNavigationItemsQuantity(expectedNumber);
    }


    @Test(dataProvider = "homePageExpectedBenefitIconsQuantity",
        dataProviderClass = PagesDataProviders.class)
    void checkBenefitIconsQuantity(int expectedNumber) {
        homePage.checkIconsNumber(expectedNumber);
    }


    @Test(dataProvider = "homePageExpectedBenefitTexts", dataProviderClass = PagesDataProviders.class)
    void checkBenefitTexts(List<String> expectedTexts) {
        homePage.checkBenefitTexts(expectedTexts);
    }


    @Test
    void checkIfIFrameExists() {
        homePage.checkIfButtonFrameDisplayed();
    }

    @Test
    void checkIfIFrameContainsButton() {
        homePage.switchToButtonFrame().checkIfButtonDisplayed().switchToParentFrame();
    }


    @Test(dataProvider = "homePageExpectedSideBarElements", dataProviderClass = PagesDataProviders.class)
    void checkSideBarMenu(List<String> expectedSideBarElements) {
        homePage.checkSidebarElements(expectedSideBarElements);
    }

}
