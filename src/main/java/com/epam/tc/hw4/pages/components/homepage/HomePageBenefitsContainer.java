package com.epam.tc.hw4.pages.components.homepage;


import com.epam.tc.hw4.pages.components.AbstractComponent;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageBenefitsContainer extends AbstractComponent {

    @FindBy(css = "span[class^=\"icons-benefit\"]")
    private List<WebElement> benefitIcons;

    @FindBy(css = "span[class=\"benefit-txt\"]")
    private List<WebElement> benefitTexts;

    public HomePageBenefitsContainer(WebDriver driver) {
        super(driver);
    }

    public int getBenefitsIconsQuantity() {
        return benefitIcons.size();
    }

    public List<String> getBenefitTextsExtracted() {
        return benefitTexts.stream().map(WebElement::getText).collect(Collectors.toList());
    }


}
