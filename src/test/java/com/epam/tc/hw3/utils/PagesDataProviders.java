package com.epam.tc.hw3.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.testng.annotations.DataProvider;

public class PagesDataProviders {

    @DataProvider(name = "loginData")
    static Object[][] loginData() {
        Properties properties = loadProperties();
        return new Object[][] {
            {properties.getProperty("username"), properties.getProperty("password"), "ROMAN IOVLEV"}};
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


    @DataProvider(name = "homePageIndexOfDropdown")
    static Object[][] homePageIndexOfDropdown() {
        return new Object[][] {{2}};
    }

    @DataProvider(name = "elementsPageExpectedLogs")
    static Object[][] elementsPageExpectedLogs() {
        return new Object[][] {{0, 2, 3, "Yellow", Map.of(
            "Water", "true",
            "Wind", "true",
            "metal", "Selen",
            "Colors", "Yellow")}};
    }

    @DataProvider(name = "homePageExpectedPageTitle")
    static Object[][] homePagePageTitleData() {
        return new Object[][] {{"Home Page"}};
    }

    @DataProvider(name = "homePageExpectedNavigationItemsQuantity")
    static Object[][] homePageExpectedNavigationItemsQuantity() {
        return new Object[][] {{4}};
    }

    @DataProvider(name = "homePageExpectedBenefitIconsQuantity")
    static Object[][] homePageExpectedBenefitIconsQuantity() {
        return new Object[][] {{4}};
    }

    @DataProvider(name = "homePageExpectedBenefitTexts")
    static Object[][] homePageBenefitTextsData() {
        return new Object[][] {{List.of("To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project", "To be flexible and\n"
            + "customizable", "To be multiplatform", "Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…")}};
    }

    @DataProvider(name = "homePageExpectedSideBarElements")
    static Object[][] homePageExpectedSideBarElements() {
        return new Object[][] {{List.of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs")}};
    }


}
