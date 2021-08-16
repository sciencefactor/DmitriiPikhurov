package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    public WebDriver webDriver;

    public PageObject(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(driver, this);
    }
}
