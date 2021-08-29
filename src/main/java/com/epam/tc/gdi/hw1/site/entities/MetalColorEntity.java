package com.epam.tc.gdi.hw1.site.entities;

import java.util.List;

public class MetalColorEntity {

    public List<Integer> summary;

    public List<String> elements;

    public String color;

    public String metals;

    public List<String> vegetables;

    @Override
    public String toString() {
        return "MetalColorEntity{"
            + "summary=" + summary
            + ", elements=" + elements
            + ", color='" + color + '\''
            + ", metals='" + metals + '\''
            + ", vegetables=" + vegetables
            + '}';
    }
}
