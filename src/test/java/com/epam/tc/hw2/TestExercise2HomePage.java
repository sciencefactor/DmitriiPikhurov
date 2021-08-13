package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestExercise2HomePage {

    private WebDriver webDriver;
    private final String expectedPageTitle = "Home Page";
    private final String expectedUserName = "ROMAN IOVLEV";
    private final Map<String, String> expectedLogNameStatus = Map.of(
        "Water", "true",
        "Wind", "true",
        "metal", "Selen",
        "Colors", "Yellow");
    private final String expectedSelectColor = "Yellow";
    private final int orderOfNameWordInLog = 1;
    private final int orderOfStatusWordInLog = 5;


    @BeforeClass
    void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void createNewDriver() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void checkExercise2Scenario() {
        // 1. Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        // 2. Assert Browser title
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(expectedPageTitle);
        // 3. Perform login
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();
        // 4. Assert User name in the left-top side of screen that user is loggined
        WebElement username = webDriver.findElement(By.id("user-name"));
        Assertions.assertThat(username.isDisplayed()).isTrue();
        Assertions.assertThat(username.getText()).isEqualTo(expectedUserName);
        // 5. Open through the header menu Service -> Different Elements Page
        webDriver.findElement(
            By.cssSelector("ul[class=\"uui-navigation nav navbar-nav m-l8\"]>li>a[class=\"dropdown-toggle\"]")).click();
        webDriver.findElement(By.cssSelector("ul[role=\"menu\"]>li>a[href=\"different-elements.html\"]")).click();
        // 6. Select checkboxes
        WebElement waterCheckBox = webDriver.findElement(By.xpath("//label[contains(string(), 'Water')]"));
        WebElement windCheckBox = webDriver.findElement(By.xpath("//label[contains(string(), 'Wind')]"));
        waterCheckBox.click();
        windCheckBox.click();
        // 7. Select radio
        WebElement selenCheckBox = webDriver.findElement(By.xpath("//label[contains(string(), 'Selen')]"));
        selenCheckBox.click();
        Assertions.assertThat(selenCheckBox.findElement(By.tagName("input")).isSelected()).isTrue();
        // 8. Select in dropdown
        WebElement selectColor = webDriver.findElement(By.cssSelector("select[class=\"uui-form-element\"]"));
        Select selectColorDropdown = new Select(selectColor);
        selectColorDropdown.selectByVisibleText(expectedSelectColor);
        // 9. Assert Log rows are correct
        List<WebElement> panelListLogs =
            webDriver.findElements(By.cssSelector("ul[class=\"panel-body-list logs\"]>li"));
        Map<String, String> logNameStatus = new HashMap<>();
        for (WebElement panelListLog : panelListLogs) {
            String itemName = panelListLog.getText().split("\\p{Punct}? +")[orderOfNameWordInLog];
            String itemStatus = panelListLog.getText().split("\\p{Punct}? +")[orderOfStatusWordInLog];
            logNameStatus.put(itemName, itemStatus);
        }
        Assertions.assertThat(logNameStatus).isEqualTo(expectedLogNameStatus);
        // 10. Close Browser
        webDriver.quit();
    }


}
