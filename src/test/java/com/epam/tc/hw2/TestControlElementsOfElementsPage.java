package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestControlElementsOfElementsPage extends AbstractTestPage {


    private static final String EXPECTED_PAGE_TITLE = "Home Page";
    private static final String EXPECTED_USER_NAME = "ROMAN IOVLEV";
    private static final Map<String, String> EXPECTED_LOG_NAME_STATUS = Map.of(
        "Water", "true",
        "Wind", "true",
        "metal", "Selen",
        "Colors", "Yellow");
    private static final String EXPECTED_SELECT_COLOR = "Yellow";
    private static final int ORDER_OF_NAME_WORD_IN_LOG = 1;
    private static final int ORDER_OF_STATUS_WORD_IN_LOG = 5;


    @Test
    void checkExercise2Scenario() {
        // 1. Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        // 2. Assert Browser title
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(EXPECTED_PAGE_TITLE);
        // 3. Perform login
        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();
        // 4. Assert User name in the left-top side of screen that user is loggined
        WebElement username = webDriver.findElement(By.id("user-name"));
        Assertions.assertThat(username.isDisplayed()).isTrue();
        Assertions.assertThat(username.getText()).isEqualTo(EXPECTED_USER_NAME);
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
        selectColorDropdown.selectByVisibleText(EXPECTED_SELECT_COLOR);
        // 9. Assert Log rows are correct
        List<WebElement> panelListLogs =
            webDriver.findElements(By.cssSelector("ul[class=\"panel-body-list logs\"]>li"));
        Map<String, String> logNameStatus = new HashMap<>();
        for (WebElement panelListLog : panelListLogs) {
            String itemName = panelListLog.getText().split("\\p{Punct}? +")[ORDER_OF_NAME_WORD_IN_LOG];
            String itemStatus = panelListLog.getText().split("\\p{Punct}? +")[ORDER_OF_STATUS_WORD_IN_LOG];
            logNameStatus.put(itemName, itemStatus);
        }
        Assertions.assertThat(logNameStatus).isEqualTo(EXPECTED_LOG_NAME_STATUS);
        // 10. Close Browser
        webDriver.quit();
    }


}
