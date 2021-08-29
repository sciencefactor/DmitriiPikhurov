package com.epam.tc.gdi.hw1.site.pages.components.simple;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;

public class CheckSelector extends MultiSelector {

    public static final String DEFAULT_OPTION = "Vegetables";

    @UI("[type=button]")
    public Button dropButton;

    @UI("[type=checkbox]")
    public HiddenCheckList checkList;

    @JDIAction("Check '{0}' for '{name}'")
    public void check(String... values) {
        dropButton.click();
        checkList.check(DEFAULT_OPTION);
        checkList.check(values);
    }
}
