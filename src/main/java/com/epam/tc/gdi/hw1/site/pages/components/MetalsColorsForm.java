package com.epam.tc.gdi.hw1.site.pages.components;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.tc.gdi.hw1.site.entities.MetalsColors;

public class MetalsColorsForm extends Form<MetalsColors> {

    @Css("div[id=summary-block]")
    public SummarySection summary;

    @Css("div[id=elements-block]")
    public ElementsSection elements;


    @JDropdown(root = "div[ui=dropdown]",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public Dropdown colors;


    @JDropdown(root = "div[ui=combobox]",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public Dropdown metals;

    @FindBy(id = "salad-dropdown")
    public SaladDropdown vegetables;

    @FindBy(id = "submit-button")
    public Button submit;
}
