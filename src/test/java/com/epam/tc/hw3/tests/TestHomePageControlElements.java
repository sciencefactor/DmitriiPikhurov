package com.epam.tc.hw3.tests;


import com.epam.tc.hw3.pages.HomePageObject;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestHomePageControlElements extends PagesUITest {

    private HomePageObject homePage;


    @BeforeClass
    void navigateToHomePage() {
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        homePage = new HomePageObject(webDriver);
    }

    @DataProvider(name = "expectedPageTitle")
    Object[][] pageTitleData() {
        return new Object[][] {{"Home Page"}};
    }


    @Test(dataProvider = "expectedPageTitle")
    void checkHomePageTitle(String expectedPageTitle) {
        homePage.checkTitle(expectedPageTitle);
    }

    @DataProvider(name = "loginData")
    Object[][] loginData() {
        return new Object[][] {
            {properties.getProperty("username"), properties.getProperty("password"), "ROMAN IOVLEV"}};
    }

    @Test(dataProvider = "loginData")
    void login(String login, String password, String expectedUserName) {
        homePage.signIn(login, password);
        homePage.checkSignIn(expectedUserName);
    }

    @DataProvider(name = "expectedNavigationItemsQuantity")
    Object[][] navigationItemsQuantity() {
        return new Object[][] {{4}};
    }

    @Test(dependsOnMethods = {"login"}, dataProvider = "expectedNavigationItemsQuantity")
    void checkNavigationItemsQuantity(int expectedNumber) {
        homePage.checkNavigationItemsQuantity(expectedNumber);
    }

    @DataProvider(name = "expectedBenefitIconsQuantity")
    Object[][] benefitIconsQuantity() {
        return new Object[][] {{4}};
    }

    @Test(dependsOnMethods = {"login"}, dataProvider = "expectedBenefitIconsQuantity")
    void checkBenefitIconsQuantity(int expectedNumber) {
        homePage.checkIconsNumber(expectedNumber);
    }

    @DataProvider(name = "expectedBenefitTexts")
    Object[][] benefitTextsData() {
        return new Object[][] {{List.of("To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project", "To be flexible and\n"
            + "customizable", "To be multiplatform", "Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…")}};
    }

    @Test(dependsOnMethods = {"login"}, dataProvider = "expectedBenefitTexts")
    void checkBenefitTexts(List<String> expectedTexts) {
        homePage.checkBenefitTexts(expectedTexts);
    }


    @Test(dependsOnMethods = {"login"})
    void checkIfIFrameExists() {
        homePage.checkIfButtonFrameDisplayed();
    }

    @Test(dependsOnMethods = {"login"})
    void checkIfIFrameContainsButton() {
        homePage.switchToButtonFrame();
        homePage.checkIfButtonDisplayed();
        homePage.switchToParentFrame();
    }

    @DataProvider(name = "expectedSideBarElements")
    Object[][] expectedSideBarElements() {
        return new Object[][] {{List.of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs")}};
    }

    @Test(dependsOnMethods = {"login"}, dataProvider = "expectedSideBarElements")
    void checkSideBarMenu(List<String> expectedSideBarElements) {
        homePage.checkSidebarElements(expectedSideBarElements);
    }

}
