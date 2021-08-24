package com.epam.tc.gdi.hw1.site.pages;


import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.gdi.hw1.site.pages.components.MetalsColorsForm;

public class MetalsColorsPage extends WebPage {

    @Css("form[class=form]")
    public static MetalsColorsForm metalsColorsForm;
}
