package com.epam.tc.hw5.tests.cucumber.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class TestContext {

    private static TestContext instance;
    private Map<String, Object> context = new HashMap<>();

    private TestContext() {
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }

    public void addTestObject(String key, Object object) {
        context.put(key, object);
    }

    public <T> void addTestObjectInList(String key, T value) {
        if (context.containsKey(key)) {
            List<T> oldList = (List<T>) context.get(key);
            oldList.add(value);
            context.put(key, oldList);
        } else {
            List<T> listSave = new ArrayList<>();
            listSave.add(value);
            context.put(key, listSave);
        }
    }


    public <T> T getObject(String key) {
        return (T) context.get(key);
    }


    public void clear() {
        context.clear();
        instance = null;
    }
}
