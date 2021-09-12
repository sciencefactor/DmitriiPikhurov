package com.epam.tc.hw6.pages.components.elements;

import com.epam.tc.hw6.pages.components.AbstractComponent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPageLogPanel extends AbstractComponent {

    @FindBy(css = "ul[class=\"panel-body-list logs\"]>li")
    List<WebElement> logsListPanel;

    private static final int ORDER_OF_NAME_WORD_IN_LOG = 1;
    private static final int ORDER_OF_STATUS_WORD_IN_LOG = 5;

    public ElementsPageLogPanel(WebDriver driver) {
        super(driver);
    }

    public Map<String, String> getMapOfLogs() {
        Map<String, String> extractedLogs = new HashMap<>();
        Consumer<WebElement> mapConsumerLogs = element -> extractedLogs.put(
            element.getText().split("\\p{Punct}? +")[ORDER_OF_NAME_WORD_IN_LOG],
            element.getText().split("\\p{Punct}? +")[ORDER_OF_STATUS_WORD_IN_LOG]);
        logsListPanel.forEach(mapConsumerLogs);
        return extractedLogs;
    }


}
