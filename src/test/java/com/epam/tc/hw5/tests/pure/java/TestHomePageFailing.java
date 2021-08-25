package com.epam.tc.hw5.tests.pure.java;

import com.epam.tc.hw5.listeners.ScreenshotListener;
import com.epam.tc.hw5.utils.TestngDataProviders;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.List;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Home Page contains navigation and sidebar items, benefits, \"Button\" iframe")
@Story("User should see all navigation and sidebar items, benefits, \"Button\" iframe")
@Listeners({ScreenshotListener.class })
public class TestHomePageFailing extends AbstractPagesUITest {


    @Test(dataProvider = "homePageExpectedPageTitle",
          dataProviderClass = TestngDataProviders.class,
          description = "Page title must be correct")
    void checkHomePageTitle(String expectedPageTitle) {
        assertionStep.checkTitle("Wrong title");
    }

    @Test(dataProvider = "userName",
          dataProviderClass = TestngDataProviders.class,
          description = "User must be logged in")
    void checkLogin(String expectedUserName) {
        assertionStep.checkLogIn(expectedUserName);
    }

    @Test(dataProvider = "homePageExpectedNavigationItemsQuantity",
          dataProviderClass = TestngDataProviders.class,
          description = "Page must have correct navigation items quantity on header")
    void checkNavigationItemsQuantity(int expectedNumber) {
        assertionStep.checkNavigationItemsQuantity(34);
    }

    @Test(dataProvider = "homePageExpectedBenefitIconsQuantity",
          dataProviderClass = TestngDataProviders.class, description = "Page must have correct benefit icons quantity")
    void checkBenefitIconsQuantity(int expectedNumber) {
        assertionStep.checkIconsNumber(12);
    }

    @Test(dataProvider = "homePageExpectedBenefitTexts",
          dataProviderClass = TestngDataProviders.class,
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
          dataProviderClass = TestngDataProviders.class, description = "Sidebar menu must have correct items")
    void checkSideBarMenu(List<String> expectedSideBarElements) {
        assertionStep.checkSidebarElements(expectedSideBarElements);
    }
}
