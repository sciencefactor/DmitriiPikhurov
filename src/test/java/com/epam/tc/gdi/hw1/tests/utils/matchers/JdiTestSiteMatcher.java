package com.epam.tc.gdi.hw1.tests.utils.matchers;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.tc.gdi.hw1.site.entities.MetalColorEntity;
import java.util.List;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;

public class JdiTestSiteMatcher {

    private JdiTestSiteMatcher() {}

    public static Matcher<WebList> containsCorrectEntity(MetalColorEntity entity) {
        return new MetalsColorsResultMatcher(entity);
    }
}
