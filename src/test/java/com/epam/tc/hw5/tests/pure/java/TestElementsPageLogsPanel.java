package com.epam.tc.hw5.tests.pure.java;

import com.epam.tc.hw5.listeners.ScreenshotListener;
import com.epam.tc.hw5.utils.TestngDataProviders;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.Map;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Logs Panel shows all user action")
@Story("User need to check all his actions on current page")
@Listeners({ScreenshotListener.class})
public class TestElementsPageLogsPanel extends AbstractPagesUITest {


    @Test(dataProvider = "userName",
          dataProviderClass = TestngDataProviders.class,
          description = "User must be logged in")
    void checkLogin(String expectedUserName) {
        actionStep.openHomePage();
        assertionStep.checkLogIn(expectedUserName);
    }

    @Test(dataProvider = "elementsPageExpectedLogs",
          dataProviderClass = TestngDataProviders.class,
          description = "Logs container must show all interactions on the page")
    void checkElementsPageLogPanel(Map<String, String> expectedLogs,
                                   String... elementsNames) {
        actionStep.navigateToElementsPage();
        actionStep.clickElementCheckBoxWithText(elementsNames[0]);
        actionStep.clickElementCheckBoxWithText(elementsNames[1]);
        actionStep.clickElementsRadioWithText(elementsNames[2]);
        actionStep.chooseColorDropdownMenu(elementsNames[3]);
        assertionStep.allInteractionWithPageShouldBeVisibleOnLogPanel(expectedLogs);
    }
}
