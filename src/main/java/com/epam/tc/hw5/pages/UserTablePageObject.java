package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.pages.components.usertable.UserDatatable;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class UserTablePageObject extends AbstractPageObject {

    public UserDatatable table;

    public UserTablePageObject(WebDriver driver) {
        super(driver);
        table = new UserDatatable(driver);
    }

    @Override
    public void logIn(String loginData, String passwordData) {
        loginMenu.logIn(loginData, passwordData);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public List<String> getLogsList() {
        return logPanel.getListOfLogs();
    }
}
