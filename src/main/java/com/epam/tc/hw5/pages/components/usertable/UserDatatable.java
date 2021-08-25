package com.epam.tc.hw5.pages.components.usertable;

import com.epam.tc.hw5.pages.components.AbstractComponent;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserDatatable extends AbstractComponent {

    @FindBy(css = "tbody>tr")
    public List<WebElement> tableRows;

    @FindBy(xpath = "//tr/td[1]")
    public List<WebElement> numerations;

    @FindBy(css = "td>select")
    public List<WebElement> dropdowns;

    @FindBy(css = "td>a")
    public List<WebElement> names;

    @FindBy(css = "div[class=\"user-descr\"]")
    public List<WebElement> descriptions;

    @FindBy(css = "div[class=\"user-descr\"]>input")
    public List<WebElement> checkboxes;

    public UserDatatable(WebDriver driver) {
        super(driver);
    }

    public List<String> getDropdownOptions() {
        Select dropOptions = new Select(dropdowns.get(0));
        return dropOptions.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void setVip(String username) {
        int index = IntStream.range(0, names.size())
                             .filter(i -> username.equals(names.get(i).getText()))
                             .findFirst().orElseThrow();
        descriptions.get(index).findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
    }
}
