package com.epam.tc.gdi.hw1.tests.utils;

import com.epam.tc.gdi.hw1.site.entities.MetalColorEntity;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class EntityToResultLogsConverter {

    private EntityToResultLogsConverter() {}

    public static List<String> getMetalsColorsResult(MetalColorEntity entity) {
        List<String> result = new ArrayList<>();
        result.add("Summary: " + entity.summary.stream().reduce(0, Integer::sum));
        result.add("Elements: " + StringUtils.join(entity.elements, ", "));
        result.add("Color: " + entity.color);
        result.add("Metal: " + entity.metals);
        result.add("Vegetables: " + StringUtils.join(entity.vegetables, ", "));
        return result;
    }
}
