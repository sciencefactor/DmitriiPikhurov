package com.epam.tc.hw4.pages.components.elements;

import com.epam.tc.hw4.pages.components.AbstractComponent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPageRadioRaw extends AbstractComponent {

    @FindBy(className = "label-radio")
    List<WebElement> elementsRadios;

    public ElementsPageRadioRaw(WebDriver driver) {
        super(driver);
    }

    public void clickElementsRadioWithIndex(int index) {
        elementsRadios.get(index).click();
    }
}
