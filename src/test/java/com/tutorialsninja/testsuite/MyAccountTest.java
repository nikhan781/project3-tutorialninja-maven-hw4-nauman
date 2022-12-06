package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {

    MyAccountPage myAccountPage = new MyAccountPage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();    //Test 1

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountLink();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        myAccountPage.selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        Assert.assertEquals(registerPage.getRegisterAccountText(), "Register Account");


    }

    //Test 2
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountLink();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        myAccountPage.selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”.
        Assert.assertEquals(loginPage.getReturningCustomerText(), "Returning Customer");

    }

    //Test 3
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountLink();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        myAccountPage.selectMyAccountOptions("Register");
        //3.3 Enter First Name
        registerPage.sendTextFirstNameField("Hulk");
        //3.4 Enter Last Name
        registerPage.sendTextLastNameField("Man");
        //3.5 Enter Email
        registerPage.sendTextEmailField("hulk");
        //3.6 Enter Telephone
        registerPage.sendTexTelephoneField("07865438934");
        //3.7 Enter Password
        registerPage.sendTextPasswordField("hulk123");
        //3.8 Enter Password Confirm
        registerPage.sendTextConfirmPasswordField("hulk123");
        //3.9 Select Subscribe Yes radio button
        registerPage.selectSubscribeButtons("Yes");
        //3.10 Click on Privacy Policy check box
        registerPage.clickOnPrivacyButton();
        //3.11 Click on Continue button
        registerPage.clickOnContinueButton();
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(registerPage.getAccountCreatedMessage(), "Your Account Has Been Created!");
        //3.13 Click on Continue button
        registerPage.clickOnContinueButtonAfterAccountCreation();
        //3.14 Click on My Account Link.
        myAccountPage.clickOnMyAccountLink();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        myAccountPage.selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        Assert.assertEquals(loginPage.getAccountLogoutText(), "Account Logout");
        //3.17 Click on Continue button
        loginPage.clickOnContinueButtonLogout();
    }

    @Test
    //Test 4
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountLink();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        myAccountPage.selectMyAccountOptions("Login");
        //4.3 Enter Email address
        loginPage.sendTextToEmailAddressField("jamesbond_007@gmail.com");
        //4.5 Enter Password
        loginPage.sendTextToPasswordField("Bond");
        //4.6 Click on Login button
        loginPage.clickOnLoginButton();
        //4.7 Verify text “My Account”
        Assert.assertEquals(myAccountPage.getMyAccountText(), "My Account");
        //4.8 Click on My Account Link.
        myAccountPage.clickOnMyAccountLink();
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        myAccountPage.selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        Assert.assertEquals(myAccountPage.getLogoutText(), "Account Logout");
        //4.11 Click on Continue button
        myAccountPage.clickContinueButtonLogout();
    }
}
