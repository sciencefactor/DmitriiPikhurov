package com.epam.tc.gdi.hw1.site.pages.components;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.tc.gdi.hw1.site.entities.User;
import org.openqa.selenium.WebElement;

public class LoginForm extends Form<User> {

    @FindBy(id = "name")
    public static WebElement name;

    @FindBy(id = "password")
    public static WebElement password;

    @FindBy(id = "login-button")
    public static WebElement loginButton;




}
