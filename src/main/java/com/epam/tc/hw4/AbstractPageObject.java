package com.epam.tc.hw4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageObject {

    public WebDriver webDriver;

    public AbstractPageObject(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public abstract void logIn(String loginData, String passwordData);
}
