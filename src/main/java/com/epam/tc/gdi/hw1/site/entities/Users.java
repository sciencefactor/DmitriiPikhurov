package com.epam.tc.gdi.hw1.site.entities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Users {

    private static final Properties properties = loadProperties();

    public static final User DEFAULT_USER = new User(getUsernameData(), getFullNameData(), getPasswordData());

    public static String getUsernameData() {
        return properties.getProperty("username");
    }

    public static String getPasswordData() {
        return properties.getProperty("password");
    }

    public static String getFullNameData() {
        return properties.getProperty("fullname");
    }

    private static Properties loadProperties() {
        Properties userProperties = new Properties();
        try (InputStream inputStream = new FileInputStream("src/test/resources/textdata/userdata.properties")) {
            userProperties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userProperties;
    }
}
