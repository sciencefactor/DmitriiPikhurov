package com.epam.tc.hw4.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestUsersProviderUtil {

    private static final Properties properties = new Properties();

    private TestUsersProviderUtil() {
    }

    public static String getUsernameData() {
        loadProperties();
        return properties.getProperty("username");
    }

    public static String getPasswordData() {
        loadProperties();
        return properties.getProperty("password");
    }

    private static Properties loadProperties() {
        try (InputStream inputStream = new FileInputStream("src/test/resources/textdata/userdata.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
