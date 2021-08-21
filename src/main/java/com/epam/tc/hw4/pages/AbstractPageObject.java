package com.epam.tc.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageObject {

    private static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    public WebDriver webDriver;


    public AbstractPageObject(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openSite(){
        webDriver.navigate().to(BASE_URL);
    }
    public abstract void logIn(String loginData, String passwordData);
}
