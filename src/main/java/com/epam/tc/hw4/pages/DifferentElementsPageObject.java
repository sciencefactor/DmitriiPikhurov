package com.epam.tc.hw4.pages;

import com.epam.tc.hw3.pages.components.elements.ElementsPageCheckboxRow;
import com.epam.tc.hw3.pages.components.elements.ElementsPageColorSelector;
import com.epam.tc.hw3.pages.components.elements.ElementsPageLogPanel;
import com.epam.tc.hw3.pages.components.elements.ElementsPageRadioRaw;
import com.epam.tc.hw3.pages.components.homepage.HomePageLoginMenu;
import io.qameta.allure.Step;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;


public class DifferentElementsPageObject extends AbstractPageObject {

    private HomePageLoginMenu loginMenu;
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
        loginMenu = new HomePageLoginMenu(driver);
    }

    @Override
    public void logIn(String loginData, String passwordData) {
        loginMenu.logIn(loginData, passwordData);
    }

    @Step
    public void clickElementCheckBoxWithIndex(int index) {
        checkboxRow.clickCheckboxWithIndex(index);
    }

    @Step
    public void clickElementsRadioWithIndex(int index) {
        radioRaw.clickElementsRadioWithIndex(index);
    }

    @Step
    public void chooseColorDropdownMenu(String color) {
        colorSelector.chooseColor(color);
    }

    @Step
    public void checkIfLogsListPanelCorrect(Map<String, String> expectedLogs) {
        Assertions.assertThat(logPanel.getMapOfLogs()).isEqualTo(expectedLogs);
    }

}