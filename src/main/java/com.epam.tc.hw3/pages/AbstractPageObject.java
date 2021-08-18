package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageObject {

    public WebDriver webDriver;

    public AbstractPageObject(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(driver, this);
    }
}
