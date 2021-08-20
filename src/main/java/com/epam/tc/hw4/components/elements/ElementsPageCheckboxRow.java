package com.epam.tc.hw4.components.elements;

import com.epam.tc.hw4.components.AbstractComponent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPageCheckboxRow extends AbstractComponent {

    @FindBy(className = "label-checkbox")
    List<WebElement> elementsCheckboxes;

    public ElementsPageCheckboxRow(WebDriver driver) {
        super(driver);
    }

    public void clickCheckboxWithIndex(int index) {
        elementsCheckboxes.get(index).click();
    }

}
