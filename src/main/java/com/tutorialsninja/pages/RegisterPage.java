package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;

public class RegisterPage extends Utility {

    By registerAccountText = By.xpath("//h1[contains(text(),'Register Account')]");

    By firstName = By.name("firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephoneNo = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By subscribeButtons = By.xpath("//div[@id='content']/form/fieldset[3]/div/div//label");
    By subscribeButtonYes = By.xpath("//div[@id='content']/form/fieldset[3]/div/div//label[1]/input");
    By subscribeButtonNo = By.xpath("//div[@id='content']/form/fieldset[3]/div/div//label[2]/input");
    By privacyButton = By.name("agree");
    By continueButton = By.xpath("//input[@class='btn btn-primary']");

    By accountCreatedMessage = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");

    By continueButtonAfterAccountCreation = By.xpath("//a[contains(text(),'Continue')]");

    public String getRegisterAccountText() {
        return getTextFromElement(registerAccountText);
    }

    public void sendTextFirstNameField(String fName) {
        sendTextToElement(firstName, fName);
    }

    public void sendTextLastNameField(String lName) {
        sendTextToElement(lastName, lName);
    }

    public void sendTextEmailField(String rEmail) {
        sendTextToElement(email, rEmail + getAlphaNumericString(2) + "@gmail.com");
    }

    public void sendTexTelephoneField(String telep) {
        sendTextToElement(telephoneNo, telep);
    }

    public void sendTextPasswordField(String pass) {
        sendTextToElement(password, pass);
    }

    public void sendTextConfirmPasswordField(String cirPass) {
        sendTextToElement(confirmPassword, cirPass);
    }

    public void selectSubscribeButtons(String op) {
        if (op.equalsIgnoreCase("Yes")) {
            clickOnElement(subscribeButtonYes);
        } else if (op.equalsIgnoreCase("No")) {
            clickOnElement(subscribeButtonNo);
        }

    }

    public void clickOnPrivacyButton() {
        clickOnElement(privacyButton);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public String getAccountCreatedMessage() {
        return getTextFromElement(accountCreatedMessage);
    }

    public void clickOnContinueButtonAfterAccountCreation() {
        clickOnElement(continueButtonAfterAccountCreation);
    }

}
