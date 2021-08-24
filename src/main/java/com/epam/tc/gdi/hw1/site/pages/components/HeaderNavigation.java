package com.epam.tc.gdi.hw1.site.pages.components;


import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;


public class HeaderNavigation extends Section {

    @FindBy(css = "a[href=\"index.html\"]")
    public Link home;

    @FindBy(css = "a[href=\"contacts.html\"]")
    public Link contacts;

    @FindBy(css = "a[class=\"dropdown-toggle\"]")
    public Button service;

    @FindBy(css = "a[href=\"metals-colors.html\"]")
    public Link metalsColors;

    @Css("ul[class=\"dropdown-menu\"]")
    public WebList dropdown;

}
