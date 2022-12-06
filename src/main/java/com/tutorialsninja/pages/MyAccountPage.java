package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountPage extends Utility {

    By myAccountLink = By.xpath("//span[contains(text(),'My Account')]");
    By registerLink = By.xpath("//a[contains(text(),'Register')]");
    By loginLink = By.xpath("//li[@class='dropdown open']/ul/li[2]");

    By myAccountText = By.xpath("//h2[contains(text(),'My Account')]");

    By logoutText = By.xpath("//h1[contains(text(),'Account Logout')]");

    By continueButtonLogout = By.xpath("//a[contains(text(),'Continue')]");


    By listOfMyAccountOptions = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li");

    //Method to click on My Account
    public void clickOnMyAccountLink() {
        clickOnElement(myAccountLink);
    }

    //Method to click on Register link
    public void clickOnRegisterLink() {
        clickOnElement(registerLink);
    }

    //Method to click on Login link
    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }

    public void selectMyAccountOptions(String options) {
        //clickOnElement(myAccountLink);
        List<WebElement> accountOptionList = driver.findElements(listOfMyAccountOptions);
        for (WebElement accountOptions : accountOptionList) {
            if (accountOptions.getText().equalsIgnoreCase(options)) {
                accountOptions.click();
                break;
            }
        }
    }

    public String getMyAccountText() {
        return getTextFromElement(myAccountText);
    }

    public String getLogoutText() {
        return getTextFromElement(logoutText);
    }

    public void clickContinueButtonLogout() {
        clickOnElement(continueButtonLogout);
    }

}
