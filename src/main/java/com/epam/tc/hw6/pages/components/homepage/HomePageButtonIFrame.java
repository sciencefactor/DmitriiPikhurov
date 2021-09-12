package com.epam.tc.hw6.pages.components.homepage;


import com.epam.tc.hw6.pages.components.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageButtonIFrame extends AbstractComponent {

    @FindBy(id = "frame")
    private WebElement buttonFrame;

    @FindBy(id = "frame-button")
    private WebElement inFrameButton;

    public HomePageButtonIFrame(WebDriver driver) {
        super(driver);
    }

    public WebElement getButtonIFrame() {
        return buttonFrame;
    }

    public WebElement getButton() {
        return inFrameButton;
    }

}
