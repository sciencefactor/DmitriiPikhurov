package com.epam.tc.gdi.hw1.tests;

import static com.epam.tc.gdi.hw1.site.pages.MetalsColorsPage.metalsColorsForm;

import com.epam.tc.gdi.hw1.site.pages.components.Header;
import org.testng.annotations.Test;

public class TestMetalsColorsForm extends TestsInit {

    @Test
    public void fillMetalsColorsForm() {
        Header.navigation.metalsColors.click();
        metalsColorsForm.summary.oddSelector.select(3);
        metalsColorsForm.summary.evenSelector.select(2);
        metalsColorsForm.summary.calculate.click();
        metalsColorsForm.colors.select("Yellow");
        metalsColorsForm.metals.select("Selen");
        System.out.println("Element : " + metalsColorsForm.elements.checklist.get(1).getAllAttributes());
        System.out.println("Class : " + metalsColorsForm.elements.checklist.get(1).getClass());
        metalsColorsForm.elements.checklist.get(1).click();
        metalsColorsForm.elements.checklist.get(1).check();
        metalsColorsForm.elements.checklist.check(1);
        metalsColorsForm.elements.checklist.check("Water");
        metalsColorsForm.vegetables.checklist.check("Onion", "Cucumber");
    }
}
