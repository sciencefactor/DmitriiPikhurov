package com.epam.tc.gdi.hw1.site.pages;


import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.gdi.hw1.site.pages.components.complex.Header;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiTestSite {

    public static HomePage homePage;
    @Title("Metal and Colors")
    public static MetalsColorsPage metalsColorsPage;

    @Css("header")
    public static Header header;

}
