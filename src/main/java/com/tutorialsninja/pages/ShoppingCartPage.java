package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {

    By shoppingCartText = By.xpath("//div[@id='content']/h1");

    By productName = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]/a");

    By deliveryDate = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]/small[1]");

    By modelName = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[3]");

    By totalPrice = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[6]");

    By quantityField = (By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[4]/div/input"));

    By updateQty = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[4]/div/span/button[1]");

    By cartUpdateMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");

    By checkOutButton = By.xpath("//a[contains(text(),'Checkout')]");



    //This method will get shopping cart text
    public String getShoppingCartTextOnSHoppingCartPage() {
        return getTextFromElement(shoppingCartText);
    }

    //This method will get product Name
    public String getProductNameInCart() {
        return getTextFromElement(productName);
    }

    //This method will get delivery date
    public String getDeliveryDateInCart() {
        return getTextFromElement(deliveryDate);
    }

    //This method will get model Name
    public String getModelNameInCart() {
        return getTextFromElement(modelName);
    }

    //This method will get total
    public String getTotalPriceOfProducts() {
        return getTextFromElement(totalPrice);
    }

    public void updateQuantity(String qty) {
        clearTextFromElement(quantityField);
        sendTextToElement(quantityField, qty);
        clickOnElement(updateQty);
    }

    public String getShoppingCartUpdatedMessage() {
        return getTextFromElement(cartUpdateMessage);
    }

    public void clickOnCheckOutButton() {
        clickOnElement(checkOutButton);
    }



}
