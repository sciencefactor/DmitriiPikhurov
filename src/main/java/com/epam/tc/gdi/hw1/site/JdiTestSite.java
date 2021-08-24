package com.epam.tc.gdi.hw1.site;


import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.gdi.hw1.site.pages.HomePage;
import com.epam.tc.gdi.hw1.site.pages.MetalsColorsPage;
import com.epam.tc.gdi.hw1.site.pages.components.Header;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiTestSite {

    public static HomePage homePage;
    public static MetalsColorsPage metalsColorsPage;

    @Css("header")
    public static Header header;

}
