package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductSelectionPage extends Utility {

    By productName = By.xpath("(//div[@class='col-sm-4'])[2]/h1");
    By calendarButton = By.cssSelector("i[class='fa fa-calendar']");

    By monthAndYearInCalendar = By.xpath("//div[@class='datepicker']/div[1]/table/thead/tr[1]/th[2]");

    By nextMonthAndYearButtonInCalendar = By.xpath("//div[@class='datepicker']/div[1]/table/thead/tr[1]/th[3]");

    By datesInCalendar = By.xpath("//div[@class='datepicker']//div//table//td");
    By selectQuantity = By.xpath("//input[@id='input-quantity']");

    By addToCartButton = By.id("button-cart");

    By successMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");

    By shoppingCartLinkInSuccessMessage = By.xpath("//a[contains(text(),'shopping cart')]");


    //This method will get the product name
    public String getSelectedProductName() {
        return getTextFromElement(productName);
    }

    //This method will click on calendar button
    public void clickOnCalendarButton() {
        clickOnElement(calendarButton);
    }

    //This method will get current Month and Year on calendar
    public String getCurrentMonthAndYearOnCalendar() {
        return getTextFromElement(monthAndYearInCalendar);
    }

    //This method will click on next mont and year button on calendar
    public void clickOnNextMonthAndYEarCalendarButton() {
        clickOnElement(nextMonthAndYearButtonInCalendar);
    }

    //This method will select date and yea
    public void selectDateAndYearOnCalendar(String month, String year) {
        clickOnElement(calendarButton);
        while (true) {
            String monthYear = getTextFromElement(monthAndYearInCalendar);
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yr = arr[1];

            if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextMonthAndYearButtonInCalendar);
            }

        }
    }

    //This method will select the date
    public void selectDateOnCalendar(String date) {
        List<WebElement> allDates = driver.findElements(datesInCalendar);
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;

            }
        }
    }


    //This method will send text to qty box
    public void enterQuantityRequired(String quantity) {
        clearTextFromElement(selectQuantity);
        sendTextToElement(selectQuantity, quantity);
    }

    //This method will click on Add to Cart button
    public void clickAddToCartButton() {
        clickOnElement(addToCartButton);
    }

    //This method will get the “Success: You have added HP LP3065 to your shopping cart!” message after clicking on Add To Cart
    public String getsuccessMessageAfterClickingAddToCartButton() {
        return getTextFromElement(successMessage);
    }


    //This method will click on Shopping Cart link in success message
    public void clickShoppingCartButtonInMessage() {
        clickOnElement(shoppingCartLinkInSuccessMessage);
    }

}

