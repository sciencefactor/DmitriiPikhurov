package com.epam.tc.hw6.pages.components.elements;

import com.epam.tc.hw6.pages.components.AbstractComponent;
import java.util.List;
import java.util.function.Predicate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPageRadioRaw extends AbstractComponent {

    @FindBy(className = "label-radio")
    List<WebElement> elementsRadios;

    public ElementsPageRadioRaw(WebDriver driver) {
        super(driver);
    }

    public void clickElementsRadioWithText(String text) {
        Predicate<String> predicate = element -> element.equals(text);
        elementsRadios.stream()
                          .filter(webElement -> predicate.test(webElement.getText()))
                          .findFirst()
                          .orElseThrow()
                          .click();
    }
}
