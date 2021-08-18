package com.epam.tc.hw3.bonus.fluent.pages;

import com.epam.tc.hw3.pages.AbstractPageObject;
import com.epam.tc.hw3.pages.components.elements.ElementsPageCheckboxRow;
import com.epam.tc.hw3.pages.components.elements.ElementsPageColorSelector;
import com.epam.tc.hw3.pages.components.elements.ElementsPageLogPanel;
import com.epam.tc.hw3.pages.components.elements.ElementsPageRadioRaw;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;


public class FluentDifferentElementsPageObject extends AbstractPageObject {

    private ElementsPageCheckboxRow checkboxRow;
    private ElementsPageRadioRaw radioRaw;
    private ElementsPageColorSelector colorSelector;
    private ElementsPageLogPanel logPanel;

    public FluentDifferentElementsPageObject(WebDriver driver) {
        super(driver);
        checkboxRow = new ElementsPageCheckboxRow(driver);
        radioRaw = new ElementsPageRadioRaw(driver);
        colorSelector = new ElementsPageColorSelector(driver);
        logPanel = new ElementsPageLogPanel(driver);
    }

    public FluentDifferentElementsPageObject clickElementCheckBoxWithIndex(int index) {
        checkboxRow.clickCheckboxWithIndex(index);
        return this;
    }


    public FluentDifferentElementsPageObject clickElementsRadioWithIndex(int index) {
        radioRaw.clickElementsRadioWithIndex(index);
        return this;
    }

    public FluentDifferentElementsPageObject chooseColorDropdownMenu(String color) {
        colorSelector.chooseColor(color);
        return this;
    }

    public FluentDifferentElementsPageObject checkIfLogsListPanelCorrect(Map<String, String> expectedLogs) {
        Assertions.assertThat(logPanel.getMapOfLogs()).isEqualTo(expectedLogs);
        return this;
    }

}
