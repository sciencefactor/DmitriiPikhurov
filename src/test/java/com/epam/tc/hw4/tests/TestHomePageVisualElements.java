package com.epam.tc.hw4.tests;

import com.epam.tc.hw4.listeners.ScreenshotListener;
import com.epam.tc.hw4.utils.PagesDataProviders;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.List;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Home Page contains navigation and sidebar items, benefits, \"Button\" iframe")
@Story("User should see all navigation and sidebar items, benefits, \"Button\" iframe")
@Listeners({ScreenshotListener.class })
public class TestHomePageVisualElements extends AbstractPagesUITest {


    @Test(dataProvider = "homePageExpectedPageTitle",
          dataProviderClass = PagesDataProviders.class,
          description = "Page title must be correct")
    void checkHomePageTitle(String expectedPageTitle) {
        assertionStep.checkTitle(expectedPageTitle);
    }

    @Test(dataProvider = "userName",
          dataProviderClass = PagesDataProviders.class,
          description = "User must be logged in")
    void checkLogin(String expectedUserName) {
        assertionStep.checkLogIn(expectedUserName);
    }

    @Test(dataProvider = "homePageExpectedNavigationItemsQuantity",
          dataProviderClass = PagesDataProviders.class,
          description = "Page must have correct navigation items quantity on header")
    void checkNavigationItemsQuantity(int expectedNumber) {
        assertionStep.checkNavigationItemsQuantity(expectedNumber);
    }

    @Test(dataProvider = "homePageExpectedBenefitIconsQuantity",
          dataProviderClass = PagesDataProviders.class, description = "Page must have correct benefit icons quantity")
    void checkBenefitIconsQuantity(int expectedNumber) {
        assertionStep.checkIconsNumber(expectedNumber);
    }

    @Test(dataProvider = "homePageExpectedBenefitTexts",
          dataProviderClass = PagesDataProviders.class,
          description = "Benefit containers must have correct text")
    void checkBenefitTexts(List<String> expectedTexts) {
        assertionStep.checkBenefitTexts(expectedTexts);
    }

    @Test(description = "Page must have \"Button\" iframe")
    void checkIfIFrameExists() {
        assertionStep.checkIfButtonFrameDisplayed();
    }

    @Test(description = "\"Button\" iframe must have button")
    void checkIfIFrameContainsButton() {
        actionStep.switchToButtonFrame();
        assertionStep.checkIfButtonDisplayed();
        actionStep.switchToParentFrame();
    }

    @Test(dataProvider = "homePageExpectedSideBarElements",
          dataProviderClass = PagesDataProviders.class, description = "Sidebar menu must have correct items")
    void checkSideBarMenu(List<String> expectedSideBarElements) {
        assertionStep.checkSidebarElements(expectedSideBarElements);
    }
}
