package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {

    //Daclaring By Variable
    By currencySelectionLink = By.cssSelector("i[class='fa fa-caret-down']");

    By desktopLink = By.xpath("//ul[@class='nav navbar-nav']/li[1]");

    By showAllDesktop = By.xpath("//a[contains(text(),'Show All Desktops')]");
    By laptopAndNotebooks = By.xpath("//ul[@class='nav navbar-nav']/li[2]");
    By showAllLaptopsAndNotebooks = By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]");

    By listOfCurrencies = By.xpath("//div[@class='btn-group open']/ul/li");



    //Method to select currency
    public void selectRequiredCurrency() {
        clickOnElement(currencySelectionLink);
        List<WebElement> currencyList = driver.findElements(listOfCurrencies);
        for (WebElement currency : currencyList) {
            if (currency.getText().equalsIgnoreCase("£ Pound Sterling")) {
                currency.click();
                break;
            }
        }
    }

    //Method to hover mouse on Desktops link
    public void hoverOverDesktopLink() {
        clickOnElement(desktopLink);
    }

    //Method to hover mouse on Laptop and Notebooks link
    public void hoverOverLaptopsAndNotebooksLink() {
        clickOnElement(laptopAndNotebooks);
    }

    //Method to click on Show All Desktops link
    public void clickOnShowAllDesktopsLink() {
        clickOnElement(showAllDesktop);
    }

    //Method to click on Show All Laptop & Notebooks link
    public void clickOnShowAllLaptopAndNotebooksLink() {
        clickOnElement(showAllLaptopsAndNotebooks);
    }


}
