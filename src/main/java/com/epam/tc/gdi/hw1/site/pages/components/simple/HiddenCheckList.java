package com.epam.tc.gdi.hw1.site.pages.components.simple;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.Checklist;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HiddenCheckList extends Checklist {

    @Override
    @JDIAction("Check '{0}' checkboxes in '{name}' checklist")
    public void check(String... names) {
        List<WebElement> checkList = this.list().webElements();
        List<WebElement> labels = checkList.stream()
                                           .map(webElement -> webElement
                                               .findElement(By.xpath("following-sibling::label")))
                                           .collect(Collectors.toList());
        labels.stream()
              .filter(label -> Arrays.stream(names).anyMatch(value -> label.getText().equalsIgnoreCase(value)))
              .forEach(WebElement::click);
    }
}


