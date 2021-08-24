package com.epam.tc.gdi.hw1.site.pages.components;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;

public class SaladDropdown extends Dropdown {

    @Css("input[type=checkbox]")
    public Checklist checklist;
}
