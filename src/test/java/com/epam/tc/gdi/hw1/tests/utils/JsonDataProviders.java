package com.epam.tc.gdi.hw1.tests.utils;

import com.epam.tc.gdi.hw1.site.entities.MetalColorEntity;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map.Entry;
import org.testng.annotations.DataProvider;

public class JsonDataProviders {

    private static final String METALS_COLORS_JSON = "src/test/resources/entities/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "getMetalAndColorEntities")
    public static Object[][] getMetalAndColorEntities() {
        JsonReader reader = tryReadJson();
        JsonObject jsonElements = JsonParser.parseReader(reader).getAsJsonObject();
        return jsonElements.entrySet()
                                             .stream()
                                             .map(Entry::getValue)
                                             .map(JsonDataProviders::parseMetalColorEntity)
                                             .map(entry -> new Object[] {entry})
                                             .toArray(Object[][]::new);
    }

    private static MetalColorEntity parseMetalColorEntity(JsonElement jsonObject) {
        return new Gson().fromJson(jsonObject, MetalColorEntity.class);
    }

    private static JsonReader tryReadJson() {
        JsonReader reader = null;
        try {
            reader = new JsonReader(
                new FileReader(METALS_COLORS_JSON));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return reader;
    }
}
