package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utility {

    By desktopText = By.xpath("//h2[contains(text(),'Desktops')]");
    By sortBy = By.xpath("//select[@id='input-sort']");

    By listOfProducts = By.xpath("//h4/a");

    By hpLp2065 = By.xpath("//a[contains(text(),'HP LP3065')]");


    //This will get Desktop text
    public String getDesktopPageText() {
        return getTextFromElement(desktopText);
    }

    //This method will select A to Z
    public void sortByAtoZ(){
        selectByVisibleTextFromDropDown(sortBy, "Name (A - Z)");
    }

    public void sortByZtoA(){
        selectByVisibleTextFromDropDown(sortBy, "Name (Z - A)");
    }
    public ArrayList beforeSortTheProducts() {
        List<WebElement> products = driver.findElements(listOfProducts);
        ArrayList<String> originalProductList = new ArrayList<>();
        for (WebElement list : products) {
            originalProductList.add(list.getText());
        }
        return originalProductList;
    }

    public ArrayList afterSortingTheProducts() {
        Collections.reverse(beforeSortTheProducts());
        System.out.println(beforeSortTheProducts());
        List<WebElement> products = driver.findElements(listOfProducts);
        ArrayList<String> afterSortList = new ArrayList<>();
        for (WebElement newList : products) {
            afterSortList.add(newList.getText());
        }
        return afterSortList;
    }

    //This method will click on HP LP3065
    public void clickOnHpLPDesktop() {
        clickOnElement(hpLp2065);
    }

}
