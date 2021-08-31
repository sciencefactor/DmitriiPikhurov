package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.pages.components.LogPanel;
import com.epam.tc.hw5.pages.components.LoginMenu;
import com.epam.tc.hw5.pages.components.NavigationBar;
import com.epam.tc.hw5.pages.components.homepage.HomePageSidebar;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageObject {

    private static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    public WebDriver webDriver;

    protected LoginMenu loginMenu;
    protected NavigationBar navigationBar;
    protected HomePageSidebar sidebar;
    protected LogPanel logPanel;

    public AbstractPageObject(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(driver, this);
        loginMenu = new LoginMenu(driver);
        navigationBar = new NavigationBar(driver);
        sidebar = new HomePageSidebar(driver);
        logPanel = new LogPanel(driver);
    }

    public void openSite() {
        webDriver.navigate().to(BASE_URL);
    }

    public abstract void logIn(String loginData, String passwordData);

    public Map<String, String> getMapOfLogsFromLogPanel() {
        return logPanel.getMapOfLogs();
    }
}
