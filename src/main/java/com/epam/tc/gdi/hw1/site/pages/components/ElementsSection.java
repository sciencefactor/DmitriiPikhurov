package com.epam.tc.gdi.hw1.site.pages.components;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.support.FindAll;

public class ElementsSection {

    @UI("[type=checkbox]")
    public Checklist checklist;
}
