package com.epam.tc.hw3.tests;


import com.epam.tc.hw3.pages.HomePageObject;
import com.epam.tc.hw3.utils.PagesDataProviders;
import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHomePageControlElements extends AbstractPagesUITest {


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
        homePage.switchToButtonFrame();
        homePage.checkIfButtonDisplayed();
        homePage.switchToParentFrame();
    }


    @Test(dataProvider = "homePageExpectedSideBarElements",
        dataProviderClass = PagesDataProviders.class)
    void checkSideBarMenu(List<String> expectedSideBarElements) {
        homePage.checkSidebarElements(expectedSideBarElements);
    }

}
