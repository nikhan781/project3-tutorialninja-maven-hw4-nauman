package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class CheckoutPage extends Utility {

    By checkoutText = By.xpath("//h1[contains(text(),'Checkout')]");

    By newCustomerText = By.xpath("//h2[contains(text(),'New Customer')]");

    By guestCheckBox = By.xpath("//div[@class='panel-group']/div[1]/div[2]/div/div/div[1]/div[2]/label/input");

    By continueButton = By.xpath("//input[@id='button-account']");

    By firstName = By.xpath("//input[@id='input-payment-firstname']");

    By lastName = By.xpath("//input[@id='input-payment-lastname']");

    By email = By.xpath("//input[@id='input-payment-email']");

    By telephone = By.xpath("//input[@id='input-payment-telephone']");

    By address = By.xpath("//input[@id='input-payment-address-1']");

    By city = By.xpath("//input[@id='input-payment-city']");

    By postcode = By.xpath("//input[@id='input-payment-postcode']");

    By country = By.xpath("//select[@id='input-payment-country']");

    By region = By.xpath("//select[@id='input-payment-zone']");

    By guestContinueButton = By.cssSelector("#button-guest");

    By commentField = By.xpath("//div[@class='panel-group']/div[3]/div[2]/div[1]/p[2]/textarea[1]");

    By termAndConditionsCheckBox = By.name("agree");
    By continueButtonInCommentSection = By.xpath("//input[@id='button-payment-method']");
    By paymentErrorMessage = By.xpath("//div[@class='panel-group']/div[3]/div[2]/div/div[1]");

    public String getCheckOutPageText() {
        return getTextFromElement(checkoutText);
    }

    public String getNewCustomerText() {
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckout() {
        clickOnElement(guestCheckBox);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public void sendTextToFirstNameField(String fName) {
        sendTextToElement(firstName, fName + getAlphaNumericString(2));
    }

    public void sendTextToLastNameField(String lname) {
        sendTextToElement(lastName, lname + getAlphaNumericString(2));
    }

    public void sendTextToEmailField(String uEmail) {
        sendTextToElement(email, uEmail + getAlphaNumericString(2) + "@gmail.com");
    }

    public void sendTextToTelephoneField(String tele) {
        sendTextToElement(telephone, tele);
    }

    public void sendTextToAddressField(String add) {
        sendTextToElement(address, add);
    }

    public void sendTextToCityField(String uCty) {
        sendTextToElement(city, uCty);
    }

    public void sendTextToPostCOdeField(String pCode) {
        sendTextToElement(postcode, pCode + getAlphaNumericString(1));
    }

    public void selectCountry(String uCountry) {
        selectByVisibleTextFromDropDown(country, uCountry);
    }

    public void selectRegion(String uRegion) {
        selectByVisibleTextFromDropDown(region, uRegion);
    }

    public void clickOnGuestContinueButton() {
        clickOnElement(guestContinueButton);
    }

    public void sendTextToAddCommentBox(String comment) {
        sendTextToElement(commentField, comment);
    }

    public void clickOnTermAndConditionsCheckBox() {
        clickOnElement(termAndConditionsCheckBox);
    }

    public void clickOnContinueButtonInCommentSection() {
        clickOnElement(continueButtonInCommentSection);
    }

    public String getPaymentErrorMessage() {
        return getTextFromElement(paymentErrorMessage);
    }


}
