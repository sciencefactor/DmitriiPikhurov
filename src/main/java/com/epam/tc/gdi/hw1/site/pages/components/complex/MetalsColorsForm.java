package com.epam.tc.gdi.hw1.site.pages.components.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.tc.gdi.hw1.site.entities.MetalColorEntity;
import com.epam.tc.gdi.hw1.site.pages.components.simple.CheckSelector;
import com.epam.tc.gdi.hw1.site.pages.components.simple.ElementsSection;
import com.epam.tc.gdi.hw1.site.pages.components.simple.SummarySection;

public class MetalsColorsForm extends Form<MetalColorEntity> {

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
    public CheckSelector vegetables;

    @FindBy(id = "submit-button")
    public Button submit;

    @JDIAction("Fill '{name}' with {0}")
    @Override
    public void fill(MetalColorEntity entity) {
        summary.oddSelector.select(entity.summary.get(0).toString());
        summary.evenSelector.select(entity.summary.get(1).toString());
        summary.calculate.click();
        colors.select(entity.color);
        metals.select(entity.metals);
        vegetables.check(entity.vegetables.toArray(String[]::new));
        elements.checklist.check(entity.elements.toArray(String[]::new));
    }

    @JDIAction(
        value = "Submit '{name}' with {0}",
        timeout = 0
    )
    @Override
    public void submit(MetalColorEntity entity) {
        this.fill(entity);
        this.submit.click();
    }
}
