package com.epam.tc.gdi.hw1.site.pages.components.simple;

import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class SummarySection {

    @Css("section[id=odds-selector]>p>input")
    public RadioButtons oddSelector;

    @Css("section[id=even-selector]>p>input")
    public RadioButtons evenSelector;

    @FindBy(id = "calculate-button")
    public Button calculate;
}
