package com.epam.tc.gdi.hw1.site.pages.components.complex;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.gdi.hw1.site.pages.components.simple.HeaderNavigation;
import com.epam.tc.gdi.hw1.site.pages.components.simple.LoginForm;

public class Header extends Section {

    @FindBy(id = "login-form")
    public static LoginForm loginForm;

    @FindBy(id = "user-icon")
    public static Icon userIcon;

    @FindBy(id = "user-name")
    public static Button userNameText;

    @Css("ul[class=\"uui-navigation nav navbar-nav m-l8\"]")
    public static HeaderNavigation navigation;
}
