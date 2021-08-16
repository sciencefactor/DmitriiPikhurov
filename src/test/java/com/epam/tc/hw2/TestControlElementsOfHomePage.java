package com.epam.tc.hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestControlElementsOfHomePage extends AbstractTestPage {


    private SoftAssertions softAssertions;
    private static final List<String> EXPECTED_NAVIGATOR_BAR_ITEMS = new ArrayList<>(
        List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
    private static final List<String> EXPECTED_BENEFIT_TEXTS = new ArrayList<>(List.of("To include good practices\n"
        + "and ideas from successful\n"
        + "EPAM project", "To be flexible and\n"
        + "customizable", "To be multiplatform", "Already have good base\n"
        + "(about 20 internal and\n"
        + "some external projects),\n"
        + "wish to get more…"));
    private static final List<String> EXPECTED_SIDEBAR_ELEMENTS = new ArrayList<>(
        List.of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs"));
    private static final int EXPECTED_ICONS_NUMBER = 4;
    private static final String EXPECTED_USER_NAME = "ROMAN IOVLEV";
    private static final String EXPECTED_PAGE_TITLE = "Home Page";

    @BeforeMethod
    void createSoftAssertion() {
        softAssertions = new SoftAssertions();
    }

    @Test
    void checkExercise1Scenario() {
        // 1. Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        // 2. Assert Browser title
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo(EXPECTED_PAGE_TITLE);
        // 3. Perform login
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();
        // 4. Assert Username is loggined
        WebElement username = webDriver.findElement(By.id("user-name"));
        softAssertions.assertThat(username.isDisplayed()).isTrue();
        softAssertions.assertThat(username.getText()).isEqualTo(EXPECTED_USER_NAME);
        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navigationBarItems = webDriver.findElements(
            By.cssSelector("ul[class=\"uui-navigation nav navbar-nav m-l8\"]>li"));
        softAssertions.assertThat(navigationBarItems.size()).isEqualTo(EXPECTED_NAVIGATOR_BAR_ITEMS.size());
        assertThatAllElementsExpectedlyDisplayed(navigationBarItems, EXPECTED_NAVIGATOR_BAR_ITEMS);
        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons = webDriver.findElements(By.cssSelector("span[class^=\"icons-benefit\"]"));
        softAssertions.assertThat(benefitIcons.size()).isEqualTo(EXPECTED_ICONS_NUMBER);
        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitTexts = webDriver.findElements(By.cssSelector("span[class=\"benefit-txt\"]"));
        assertThatAllElementsExpectedlyDisplayed(benefitTexts, EXPECTED_BENEFIT_TEXTS);
        // 8. Assert that there is the iframe with “Frame Button” exist
        WebElement buttonFrame = webDriver.findElement(By.id("frame"));
        softAssertions.assertThat(buttonFrame.isDisplayed()).isTrue();
        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(buttonFrame);
        WebElement inFrameButton = webDriver.findElement(By.id("frame-button"));
        softAssertions.assertThat(inFrameButton.isDisplayed()).isTrue();
        // 10. Switch to original window back
        webDriver.switchTo().parentFrame();
        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sidebarElements = webDriver.findElements(By.cssSelector("ul[class=\"sidebar-menu left\"]>li"));
        softAssertions.assertThat(sidebarElements.size()).isEqualTo(EXPECTED_SIDEBAR_ELEMENTS.size());
        assertThatAllElementsExpectedlyDisplayed(sidebarElements, EXPECTED_SIDEBAR_ELEMENTS);
        softAssertions.assertAll();
        // 12. Close Browser
        webDriver.quit();
    }

    private void assertThatAllElementsExpectedlyDisplayed(List<WebElement> actualElements,
                                                          List<String> expectedElements) {
        actualElements.forEach(element -> softAssertions.assertThat(element.isDisplayed()).isTrue());
        List<String> actualTexts = actualElements.stream().map(WebElement::getText).collect(Collectors.toList());
        softAssertions.assertThat(actualTexts).isEqualTo(expectedElements);
    }
}
