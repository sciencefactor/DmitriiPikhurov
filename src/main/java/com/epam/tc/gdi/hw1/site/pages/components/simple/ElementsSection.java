package com.epam.tc.gdi.hw1.site.pages.components.simple;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;


public class ElementsSection extends Section {

    @UI("[type=checkbox]")
    public HiddenCheckList checklist;
}
