package com.epam.tc.hw4.pages.components.homepage;

import com.epam.tc.hw4.pages.components.AbstractComponent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageNavigationBar extends AbstractComponent {

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

    public void clickItemWithIndex(int index) {
        navigationBarItems.get(index).click();
    }

    public void clickRefDifferentElements() {
        refToDifferentElements.click();
    }


}
