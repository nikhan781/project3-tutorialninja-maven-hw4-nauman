package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TopMenuPage extends Utility {

    By topMenu = By.xpath("//nav[@id='menu']//ul//li//a");


    public void selectMenu(String menu) {
        List<WebElement> menuList = driver.findElements(topMenu);
        try {
            for (WebElement list : menuList) {
                if (list.getText().equalsIgnoreCase(menu)) {
                    list.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            menuList = driver.findElements(topMenu);
        }
    }

    public void hoverOverMainMenuBar(String mainMenu) {
        Actions actions = new Actions(driver);
        List<WebElement> menuList = driver.findElements(topMenu);
        try {
            for (WebElement list : menuList) {
                if (list.getText().equalsIgnoreCase(mainMenu)) {
                    actions.moveToElement(list).build().perform();
                }
            }
        } catch (StaleElementReferenceException e) {
            menuList = driver.findElements(topMenu);
        }
    }
}
