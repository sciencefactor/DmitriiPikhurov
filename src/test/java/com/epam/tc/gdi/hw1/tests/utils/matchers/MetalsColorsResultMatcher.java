package com.epam.tc.gdi.hw1.tests.utils.matchers;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.tc.gdi.hw1.site.entities.MetalColorEntity;
import com.epam.tc.gdi.hw1.tests.utils.EntityToResultLogsConverter;
import java.util.List;
import java.util.stream.Collectors;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

public class MetalsColorsResultMatcher extends TypeSafeMatcher<WebList> {

    private final List<String> expectedLogs;

    public MetalsColorsResultMatcher(MetalColorEntity entity) {
        this.expectedLogs = EntityToResultLogsConverter.getMetalsColorsResult(entity);
    }

    @Override
    protected boolean matchesSafely(WebList uiElements) {
        List<String> actualResult = uiElements.webElements()
                                              .stream()
                                              .map(WebElement::getText)
                                              .collect(Collectors.toList());
        return actualResult.containsAll(expectedLogs);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("contains data from entity:" + expectedLogs);
    }
}
