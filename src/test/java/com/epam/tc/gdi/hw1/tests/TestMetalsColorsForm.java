package com.epam.tc.gdi.hw1.tests;

import static com.epam.tc.gdi.hw1.site.pages.JdiTestSite.metalsColorsPage;
import static com.epam.tc.gdi.hw1.tests.utils.matchers.JdiTestSiteMatcher.containsCorrectEntity;
import static org.hamcrest.MatcherAssert.assertThat;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.tc.gdi.hw1.site.entities.MetalColorEntity;
import com.epam.tc.gdi.hw1.tests.utils.JsonDataProviders;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestMetalsColorsForm extends TestsInit {

    @Test(dataProvider = "getMetalAndColorEntities", dataProviderClass = JsonDataProviders.class)
    public void fillMetalsColorsForm(MetalColorEntity metalColorEntity) {
        metalsColorsPage.shouldBeOpened();
        metalsColorsPage.metalsColorsForm.submit(metalColorEntity);
        assertThat(metalsColorsPage.result, containsCorrectEntity(metalColorEntity));
    }

    @AfterMethod
    void clearForm(){
        WebPage.refresh();
    }
}
