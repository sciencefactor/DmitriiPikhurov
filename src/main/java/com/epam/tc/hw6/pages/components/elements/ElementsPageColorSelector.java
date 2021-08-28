package com.epam.tc.hw6.pages.components.elements;

import com.epam.tc.hw6.pages.components.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ElementsPageColorSelector extends AbstractComponent {

    @FindBy(css = "select[class=\"uui-form-element\"]")
    WebElement colorSelector;

    public ElementsPageColorSelector(WebDriver driver) {
        super(driver);
    }

    public void chooseColor(String color) {
        Select selectColorDropdown = new Select(colorSelector);
        selectColorDropdown.selectByVisibleText(color);
    }

}
