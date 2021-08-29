package com.epam.tc.gdi.hw1.site.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.gdi.hw1.site.pages.components.complex.Header;
import com.epam.tc.gdi.hw1.site.pages.components.complex.MetalsColorsForm;

public class MetalsColorsPage extends WebPage {

    @Css("form[class=form]")
    public MetalsColorsForm metalsColorsForm;

    @Css("ul[class=\"panel-body-list results\"]>li")
    public WebList result;

    public void shouldBeOpened() {
        if (!getTitle().equalsIgnoreCase("metals and colors")) {
            Header.navigation.metalsColors.click();
        }
    }
}
