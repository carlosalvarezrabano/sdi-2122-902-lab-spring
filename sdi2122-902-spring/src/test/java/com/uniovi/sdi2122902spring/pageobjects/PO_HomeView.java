package com.uniovi.sdi2122902spring.pageobjects;

import com.uniovi.sdi2122902spring.util.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PO_HomeView extends PO_NavView {

    static public void checkWelcomeToPage(WebDriver driver, int language) {
        SeleniumUtils.waitLoadElementsBy(driver, "text", p.getString("welcome.message", language),
                getTimeout());
    }

    static public List<WebElement> getWelcomeMessageText(WebDriver driver, int language) {
        return SeleniumUtils.waitLoadElementsBy(driver, "text", p.getString("welcome.message",
                        language), getTimeout());
    }

    static public void checkChangeLanguage(WebDriver driver, String textLanguage1, String textLanguage,
                                           int locale1, int locale2) {
        PO_HomeView.checkWelcomeToPage(driver, locale1);
        PO_HomeView.changeLanguage(driver, textLanguage);
        PO_HomeView.checkWelcomeToPage(driver, locale2);
        PO_HomeView.changeLanguage(driver, textLanguage1);
        PO_HomeView.checkWelcomeToPage(driver, locale1);
    }

}
