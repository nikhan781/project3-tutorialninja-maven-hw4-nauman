package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {

    By returningCustomerText = By.xpath("//h2[contains(text(),'Returning Customer')]");

    By accountLogoutText = By.xpath("//h1[contains(text(),'Account Logout')]");

    By continueButtonLogout = By.xpath("//a[contains(text(),'Continue')]");

    By emailAddress = By.id("input-email");

    By password = By.id("input-password");

    By loginButton = By.xpath("//input[@class='btn btn-primary']");


    public String getReturningCustomerText() {
        return getTextFromElement(returningCustomerText);
    }

    public String getAccountLogoutText() {
        return getTextFromElement(accountLogoutText);
    }

    public void clickOnContinueButtonLogout() {
        clickOnElement(continueButtonLogout);
    }

    public void sendTextToEmailAddressField(String emailId) {
        sendTextToElement(emailAddress, emailId);
    }

    public void sendTextToPasswordField(String lPassword) {
        sendTextToElement(password, lPassword);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }
}
