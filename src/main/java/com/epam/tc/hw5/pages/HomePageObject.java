package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.pages.components.homepage.HomePageBenefitsContainer;
import com.epam.tc.hw5.pages.components.homepage.HomePageButtonIFrame;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject extends AbstractPageObject {


    private HomePageBenefitsContainer benefitsContainer;
    private HomePageButtonIFrame buttonIFrame;


    public HomePageObject(WebDriver driver) {
        super(driver);
        benefitsContainer = new HomePageBenefitsContainer(driver);
        buttonIFrame = new HomePageButtonIFrame(driver);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }


    @Override
    public void logIn(String loginData, String passwordData) {
        loginMenu.logIn(loginData, passwordData);
    }

    
    public WebElement getLogIn() {
        return loginMenu.getUserNameText();
    }

    
    public int getNavigationItemsQuantity() {
        return navigationBar.getNavigationBarItemsQuantity();
    }

    
    public int getIconsNumber() {
        return benefitsContainer.getBenefitsIconsQuantity();
    }

    
    public List<String> getBenefitTexts() {
        return benefitsContainer.getBenefitTextsExtracted();
    }

    
    public WebElement getButtonFrame() {
        return buttonIFrame.getButtonIFrame();
    }

    
    public void switchToButtonFrame() {
        webDriver.switchTo().frame(buttonIFrame.getButtonIFrame());
    }

    
    public WebElement getButton() {
        return buttonIFrame.getButton();
    }

    
    public void switchToParentFrame() {
        webDriver.switchTo().parentFrame();
    }

    
    public List<String> getSidebarElementsText() {
        return sidebar.getSidebarElementsExtracted();
    }


    
    public void clickRefDifferentElements() {
        navigationBar.clickRefDifferentElements();
    }

    public void clickNavigationItemService() {
        navigationBar.clickService();
    }

    public void clickHeaderUserTableButton(String pageName) {
        navigationBar.clickRefUserTable(pageName);
    }
}
