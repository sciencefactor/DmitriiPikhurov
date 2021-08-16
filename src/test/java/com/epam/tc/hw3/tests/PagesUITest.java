package com.epam.tc.hw3.tests;

import com.epam.tc.hw3.utils.WebDriverProvider;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class PagesUITest {

    protected WebDriver webDriver;
    protected Properties properties;


    @BeforeClass
    void setUp() {
        webDriver = WebDriverProvider.getChromeDriver();
        webDriver.manage().window().maximize();
    }

    @BeforeClass
    void loadProperties() {
        try (InputStream inputStream = new FileInputStream("src/test/resources/textdata/userdata.properties")) {
            Properties userProperties = new Properties();
            userProperties.load(inputStream);
            properties = userProperties;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    void closeBrowser() {
        webDriver.quit();
    }
}
