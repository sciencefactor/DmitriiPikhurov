package com.epam.tc.hw3.bonus.fluent.pages;

import com.epam.tc.hw3.pages.PageObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class FluentDifferentElementsPageObject extends PageObject {

    @FindBy(className = "label-checkbox")
    List<WebElement> elementsCheckboxes;

    @FindBy(className = "label-radio")
    List<WebElement> elementsRadios;

    @FindBy(css = "select[class=\"uui-form-element\"]")
    WebElement colorSelector;

    @FindBy(css = "ul[class=\"panel-body-list logs\"]>li")
    List<WebElement> logsListPanel;
    private static final int ORDER_OF_NAME_WORD_IN_LOG = 1;
    private static final int ORDER_OF_STATUS_WORD_IN_LOG = 5;

    public FluentDifferentElementsPageObject(WebDriver driver) {
        super(driver);
    }

    public FluentDifferentElementsPageObject clickElementCheckBoxByIndex(int index) {
        elementsCheckboxes.get(index).click();
        return this;
    }


    public FluentDifferentElementsPageObject clickElementsRadioByIndex(int index) {
        elementsRadios.get(index).click();
        return this;
    }

    public FluentDifferentElementsPageObject chooseColorDropdownMenu(String color) {
        Select selectColorDropdown = new Select(colorSelector);
        selectColorDropdown.selectByVisibleText(color);
        return this;
    }

    public FluentDifferentElementsPageObject checkIfLogsListPanelCorrect(Map<String, String> expectedLogs) {
        Map<String, String> extractedLogs = new HashMap<>();
        Consumer<WebElement> mapConsumerLogs = element -> extractedLogs.put(
            element.getText().split("\\p{Punct}? +")[ORDER_OF_NAME_WORD_IN_LOG],
            element.getText().split("\\p{Punct}? +")[ORDER_OF_STATUS_WORD_IN_LOG]);
        logsListPanel.forEach(mapConsumerLogs);
        Assertions.assertThat(extractedLogs).isEqualTo(expectedLogs);
        return this;
    }

}
