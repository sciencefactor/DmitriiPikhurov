package com.epam.tc.hw4.pages.components.homepage;

import com.epam.tc.hw4.pages.components.AbstractComponent;
import java.util.List;
import java.util.function.Predicate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageNavigationBar extends AbstractComponent {

    private final static String SERVICE = "SERVICE";

    @FindBy(css = "ul[class=\"uui-navigation nav navbar-nav m-l8\"]>li")
    private List<WebElement> navigationBarItems;

    @FindBy(css = "ul[role=\"menu\"]>li>a[href=\"different-elements.html\"]")
    private WebElement refToDifferentElements;

    public HomePageNavigationBar(WebDriver driver) {
        super(driver);
    }

    public int getNavigationBarItemsQuantity() {
        return navigationBarItems.size();
    }

    public void clickRefDifferentElements() {
        refToDifferentElements.click();
    }

    public void clickService() {
        Predicate<String> predicate = element -> element.equals(SERVICE);
        navigationBarItems.stream()
                          .filter(webElement -> predicate.test(webElement.getText()))
                          .findFirst()
                          .orElseThrow()
                          .click();
    }


}
