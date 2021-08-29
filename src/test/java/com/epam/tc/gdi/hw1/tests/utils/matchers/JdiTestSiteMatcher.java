package com.epam.tc.gdi.hw1.tests.utils.matchers;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.tc.gdi.hw1.site.entities.MetalColorEntity;
import org.hamcrest.Matcher;

public class JdiTestSiteMatcher {

    private JdiTestSiteMatcher() {}

    public static Matcher<WebList> containsCorrectEntity(MetalColorEntity entity) {
        return new MetalsColorsResultMatcher(entity);
    }
}
