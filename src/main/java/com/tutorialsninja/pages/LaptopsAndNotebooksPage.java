package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    By laptopsAndNotebooksText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By sortBy = By.xpath("//select[@id='input-sort']");
    By listOfProducts = By.xpath("//h4/a");

    By allProductsOnPage = By.xpath("//div[@id='content']/div[4]//div/child::h4/a");


    //This method will get Page name text
    public String getLaptopsAndNotebookText() {
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public void sortByPriceHigToLow() {
        selectByVisibleTextFromDropDown(sortBy, "Price (High > Low)");
    }

    public List<Double> beforeSortTheProductsByPrice() {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductPrice = new ArrayList<>();
        for (WebElement list : products) {
            String arr[] = list.getText().split("Ex Tax:");
            originalProductPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalProductPrice;
    }

    public ArrayList<Double> afterSortingTheProductsByPrice() {
        Collections.sort(beforeSortTheProductsByPrice(), Collections.reverseOrder());
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement newPriceList : products) {
            String[] arr = newPriceList.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return afterSortByPrice;
    }

    //This Method will click on a product
    public void selectAProduct(String mainMenu) {
        List<WebElement> allProducts = driver.findElements(allProductsOnPage);
        try {
            for (WebElement products : allProducts) {
                if (products.getText().equalsIgnoreCase(mainMenu)) {
                    products.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            allProducts = driver.findElements(allProductsOnPage);
        }
    }


}
