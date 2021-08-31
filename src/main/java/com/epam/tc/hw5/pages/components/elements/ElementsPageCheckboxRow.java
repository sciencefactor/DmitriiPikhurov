package com.epam.tc.hw5.pages.components.elements;

import com.epam.tc.hw5.pages.components.AbstractComponent;
import java.util.List;
import java.util.function.Predicate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPageCheckboxRow extends AbstractComponent {

    @FindBy(className = "label-checkbox")
    List<WebElement> elementsCheckboxes;

    public ElementsPageCheckboxRow(WebDriver driver) {
        super(driver);
    }

    public void clickCheckboxWithText(String text) {
        Predicate<String> predicate = element -> element.equals(text);
        elementsCheckboxes.stream()
                      .filter(webElement -> predicate.test(webElement.getText()))
                      .findFirst()
                      .orElseThrow()
                      .click();
    }
}
