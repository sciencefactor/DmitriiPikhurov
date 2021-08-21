package com.epam.tc.hw4.pages.components.homepage;

import com.epam.tc.hw4.pages.components.AbstractComponent;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageSidebar extends AbstractComponent {

    @FindBy(css = "ul[class=\"sidebar-menu left\"]>li")
    private List<WebElement> sidebarElements;

    public HomePageSidebar(WebDriver driver) {
        super(driver);
    }

    public List<String> getSidebarElementsExtracted() {
        return sidebarElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
