package com.epam.tc.hw4.pages;

import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.Speed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageObject {

    public WebDriver webDriver;

    public AbstractPageObject(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step
    public abstract void logIn(String loginData, String passwordData);
}
