package com.uniovi.sdi2122902spring.pageobjects;

import com.uniovi.sdi2122902spring.util.SeleniumUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class PO_NavView extends PO_View {

    public static void clickOption(WebDriver driver, String textOption, String criterio, String targetText) {
        List<WebElement> elements = SeleniumUtils.waitLoadElementsBy(driver, "@href", textOption,
                getTimeout());
        Assertions.assertEquals(1, elements.size());
        elements.get(0).click();
        elements = SeleniumUtils.waitLoadElementsBy(driver, criterio, targetText, getTimeout());
        Assertions.assertEquals(1, elements.size());
    }

    public static void changeLanguage(WebDriver driver, String textLanguage) {
        List<WebElement> languageButton = SeleniumUtils.waitLoadElementsBy(driver, "id",
                "btnLanguage", getTimeout());
        languageButton.get(0).click();
        SeleniumUtils.waitLoadElementsBy(driver, "id", "languageDropdownMenuButton", getTimeout());
        List<WebElement> SelectedLanguage = SeleniumUtils.waitLoadElementsBy(driver, "id", textLanguage,
                getTimeout());
        SelectedLanguage.get(0).click();
    }

}
