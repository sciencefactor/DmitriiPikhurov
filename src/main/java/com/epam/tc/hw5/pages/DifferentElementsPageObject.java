package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.pages.components.elements.ElementsPageCheckboxRow;
import com.epam.tc.hw5.pages.components.elements.ElementsPageColorSelector;
import com.epam.tc.hw5.pages.components.elements.ElementsPageRadioRaw;
import org.openqa.selenium.WebDriver;

public class DifferentElementsPageObject extends AbstractPageObject {

    private ElementsPageCheckboxRow checkboxRow;
    private ElementsPageRadioRaw radioRaw;
    private ElementsPageColorSelector colorSelector;

    public DifferentElementsPageObject(WebDriver driver) {
        super(driver);
        checkboxRow = new ElementsPageCheckboxRow(driver);
        radioRaw = new ElementsPageRadioRaw(driver);
        colorSelector = new ElementsPageColorSelector(driver);
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

    


}
