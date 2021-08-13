package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class TestExercise1HomePage {

    private WebDriver webDriver;
    private SoftAssertions softAssertions;
    private final List<String> expectedNavigatorBarItems = new ArrayList<>(
        List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
    private final List<String> expectedBenefitTexts = new ArrayList<>(List.of("To include good practices\n" +
        "and ideas from successful\n" +
        "EPAM project", "To be flexible and\n" +
        "customizable", "To be multiplatform", "Already have good base\n" +
        "(about 20 internal and\n" +
        "some external projects),\n" +
        "wish to get more…"));
    private final List<String> expectedSidebarElements = new ArrayList<>(
        List.of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs"));
    private final int expectedIconsNumber = 4;
    private final String expectedUserName = "ROMAN IOVLEV";
    private final String expectedPageTitle = "Home Page";

    @BeforeClass
    void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void createNewDriver() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softAssertions = new SoftAssertions();
    }

    @Test
    void checkExercise1Scenario() {
        // Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        // Assert Browser title
        softAssertions.assertThat(webDriver.getTitle()).isEqualTo(expectedPageTitle);
        // Perform login
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();
        // Assert Username is loggined
        WebElement username = webDriver.findElement(By.id("user-name"));
        softAssertions.assertThat(username.isDisplayed()).isTrue();
        softAssertions.assertThat(username.getText()).isEqualTo(expectedUserName);
        // Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navigationBarItems = webDriver.findElements(
            By.cssSelector("ul[class=\"uui-navigation nav navbar-nav m-l8\"]>li"));
        softAssertions.assertThat(navigationBarItems.size()).isEqualTo(expectedNavigatorBarItems.size());
        assertThatAllElementsExpectedlyDisplayed(navigationBarItems, expectedNavigatorBarItems);
        // Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons = webDriver.findElements(By.cssSelector("span[class^=\"icons-benefit\"]"));
        softAssertions.assertThat(benefitIcons.size()).isEqualTo(expectedIconsNumber);
        // Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitTexts = webDriver.findElements(By.cssSelector("span[class=\"benefit-txt\"]"));
        assertThatAllElementsExpectedlyDisplayed(benefitTexts, expectedBenefitTexts);
        // Assert that there is the iframe with “Frame Button” exist
        WebElement buttonFrame = webDriver.findElement(By.id("frame"));
        softAssertions.assertThat(buttonFrame.isDisplayed()).isTrue();
        // Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(buttonFrame);
        WebElement inFrameButton = webDriver.findElement(By.id("frame-button"));
        softAssertions.assertThat(inFrameButton.isDisplayed()).isTrue();
        // Switch to original window back
        webDriver.switchTo().parentFrame();
        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sidebarElements = webDriver.findElements(By.cssSelector("ul[class=\"sidebar-menu left\"]>li"));
        softAssertions.assertThat(sidebarElements.size()).isEqualTo(expectedSidebarElements.size());
        assertThatAllElementsExpectedlyDisplayed(sidebarElements, expectedSidebarElements);
        //Close Browser
        webDriver.quit();
    }

    private void assertThatAllElementsExpectedlyDisplayed(List<WebElement> actualElements,
                                                          List<String> expectedElements) {
        for (int i = 0; i < actualElements.size(); i++) {
            softAssertions.assertThat(actualElements.get(i).isDisplayed()).isTrue();
            softAssertions.assertThat(actualElements.get(i).getText()).isEqualTo(expectedElements.get(i));
        }
    }
}
