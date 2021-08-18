package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.pages.components.elements.ElementsPageCheckboxRow;
import com.epam.tc.hw3.pages.components.elements.ElementsPageColorSelector;
import com.epam.tc.hw3.pages.components.elements.ElementsPageLogPanel;
import com.epam.tc.hw3.pages.components.elements.ElementsPageRadioRaw;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;


public class DifferentElementsPageObject extends AbstractPageObject {

    private ElementsPageCheckboxRow checkboxRow;
    private ElementsPageRadioRaw radioRaw;
    private ElementsPageColorSelector colorSelector;
    private ElementsPageLogPanel logPanel;

    public DifferentElementsPageObject(WebDriver driver) {
        super(driver);
        checkboxRow = new ElementsPageCheckboxRow(driver);
        radioRaw = new ElementsPageRadioRaw(driver);
        colorSelector = new ElementsPageColorSelector(driver);
        logPanel = new ElementsPageLogPanel(driver);
    }

    public void clickElementCheckBoxWithIndex(int index) {
        checkboxRow.clickCheckboxWithIndex(index);
    }


    public void clickElementsRadioWithIndex(int index) {
        radioRaw.clickElementsRadioWithIndex(index);
    }

    public void chooseColorDropdownMenu(String color) {
        colorSelector.chooseColor(color);
    }

    public void checkIfLogsListPanelCorrect(Map<String, String> expectedLogs) {
        Assertions.assertThat(logPanel.getMapOfLogs()).isEqualTo(expectedLogs);
    }

}
