package com.epam.tc.hw6.pages.components;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {

    protected WebDriver webDriver;
    protected WebDriverWait wait;

    protected AbstractComponent(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

}
