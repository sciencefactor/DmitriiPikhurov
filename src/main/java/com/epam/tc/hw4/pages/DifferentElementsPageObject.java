package com.epam.tc.hw4.pages;

import com.epam.tc.hw4.pages.components.elements.ElementsPageCheckboxRow;
import com.epam.tc.hw4.pages.components.elements.ElementsPageColorSelector;
import com.epam.tc.hw4.pages.components.elements.ElementsPageLogPanel;
import com.epam.tc.hw4.pages.components.elements.ElementsPageRadioRaw;
import com.epam.tc.hw4.pages.components.homepage.HomePageLoginMenu;
import java.util.Map;
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

    
    public void clickElementsCheckBoxWithText(String text) {
        checkboxRow.clickCheckboxWithText(text);
    }

    
    public void clickElementsRadioWithText(String text) {
        radioRaw.clickElementsRadioWithText(text);
    }

    
    public void chooseColorDropdownMenu(String color) {
        colorSelector.chooseColor(color);
    }

    
    public Map<String, String> getMapOfLogsFromLogPanel() {
        return logPanel.getMapOfLogs();
    }

}
