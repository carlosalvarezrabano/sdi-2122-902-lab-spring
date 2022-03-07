package com.uniovi.sdi2122902spring.pageobjects;

import com.uniovi.sdi2122902spring.util.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PO_PrivateView extends PO_NavView {

    static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp, String scorep) {
        SeleniumUtils.waitSeconds(driver, 5);
        new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);
        WebElement description = driver.findElement(By.name("description"));
        description.clear();
        description.sendKeys(descriptionp);
        WebElement score = driver.findElement(By.name("score"));
        score.click();
        score.clear();
        score.sendKeys(scorep);
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }

    static public void login(WebDriver driver, String username, String password) {
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        PO_LoginView.fillLoginForm(driver, username, password);
        PO_View.checkElementBy(driver,"text", username);
    }

    static public void logout(WebDriver driver) {
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        PO_PrivateView.clickOption(driver,"logout","text",loginText);
    }

    static public List<WebElement> accessMarkList(WebDriver driver) {
        String checkText = "Notas del usuario";
        List<WebElement> result = PO_View.checkElementBy(driver,"text", checkText);
        List<WebElement> markList = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr",
                PO_View.getTimeout());
        return markList;
    }

    static public List<WebElement> addMark(WebDriver driver, String description, String score) {
        List<WebElement> elements = PO_View.checkElementBy(driver,"free","//li[contains(@id, 'marks-menu')]/a");
        elements.get(0).click();
        elements = PO_View.checkElementBy(driver,"free", "//a[contains(@href, 'mark/add')]");
        elements.get(0).click();
        fillFormAddMark(driver, 3, description, "8");
        elements = PO_View.checkElementBy(driver,"free","//a[contains(@class, 'page-link')]");
        elements.get(3).click();
        elements = PO_View.checkElementBy(driver, "text", description);
        return elements;
    }

    static public void deleteMark(WebDriver driver, String checkText) {
        List<WebElement> elements = PO_View.checkElementBy(driver,"free","//li[contains(@id, 'marks-menu')]/a");
        elements.get(0).click();
        elements = PO_View.checkElementBy(driver,"free", "//a[contains(@href, 'mark/list')]");
        elements.get(0).click();
        elements = PO_View.checkElementBy(driver,"free","//a[contains(@class, 'page-link')]");
        elements.get(3).click();
        elements = PO_View.checkElementBy(driver,"free","//td[contains(text(), '"+checkText+"')]/following-sibling::*/a[contains(@href, 'mark/delete')]");
        elements.get(0).click();
        elements = PO_View.checkElementBy(driver,"free","//a[contains(@class, 'page-link')]");
        elements.get(3).click();
        SeleniumUtils.waitTextIsNotPresentOnPage(driver, checkText, PO_View.getTimeout());
    }

    static public List<WebElement> viewMarkDetails(WebDriver driver, String checkText) {
        List<WebElement> result = PO_View.checkElementBy(driver,"text", checkText);
        By enlace = By.xpath("//td[contains(text(), '"+checkText+"')]/following-sibling::*[2]");
        driver.findElement(enlace).click();
        checkText = "Detalles de la nota";
        result = PO_View.checkElementBy(driver,"text", checkText);
        return result;
    }
}
