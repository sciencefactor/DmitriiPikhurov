package com.epam.tc.hw5.pages.components;

import com.epam.tc.hw5.pages.components.AbstractComponent;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractComponent {

    private static final String SERVICE = "service";

    @FindBy(css = "ul[class=\"uui-navigation nav navbar-nav m-l8\"]>li")
    private List<WebElement> navigationBarItems;

    @FindBy(css = "ul[class=\"dropdown-menu\"]>li>a")
    private List<WebElement> serviceItems;

    @FindBy(css = "ul[role=\"menu\"]>li>a[href=\"different-elements.html\"]")
    private WebElement refToDifferentElements;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public int getNavigationBarItemsQuantity() {
        return navigationBarItems.size();
    }

    public void clickRefDifferentElements() {
        refToDifferentElements.click();
    }

    public void clickService() {
        findServiceElement().click();
    }

    private WebElement findServiceElement() {
        Predicate<String> predicate = element -> element.toLowerCase(Locale.ROOT).equals(SERVICE);
        return navigationBarItems.stream()
                          .filter(webElement -> predicate.test(webElement.getText()))
                          .findFirst()
                          .orElseThrow();
    }

    public void clickRefUserTable(String pageName) {
        Predicate<String> predicate = element -> element.toLowerCase(Locale.ROOT)
                                                        .equals(pageName.toLowerCase(Locale.ROOT));
        serviceItems.stream()
                    .filter(webElement -> predicate.test(webElement.getText()))
                    .findFirst()
                    .orElseThrow().click();
    }
}
