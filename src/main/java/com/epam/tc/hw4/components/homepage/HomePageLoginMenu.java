package com.epam.tc.hw4.components.homepage;

import com.epam.tc.hw4.components.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLoginMenu extends AbstractComponent {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userNameText;

    public HomePageLoginMenu(WebDriver driver) {
        super(driver);
    }

    public void logIn(String login, String password) {
        if (isNotSignedIn()) {
            userIcon.click();
            nameField.sendKeys(login);
            passwordField.sendKeys(password);
            loginButton.click();
        }
    }

    public WebElement getUserNameText() {
        return userNameText;
    }

    public boolean isSignedIn() {
        return userNameText.isDisplayed();
    }

    public boolean isNotSignedIn() {
        return !isSignedIn();
    }
}
