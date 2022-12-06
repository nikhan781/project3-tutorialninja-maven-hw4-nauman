package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksTest extends BaseTest {

    HomePage homePage = new HomePage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    TopMenuPage topMenuPage = new TopMenuPage();
    ProductSelectionPage productSelectionPage = new ProductSelectionPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.hoverOverLaptopsAndNotebooksLink();
        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.clickOnShowAllLaptopAndNotebooksLink();
        //1.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.sortByPriceHigToLow();
        //Verify the Product price will arrange in High to Low order.
        Assert.assertEquals(laptopsAndNotebooksPage.beforeSortTheProductsByPrice(), laptopsAndNotebooksPage.afterSortingTheProductsByPrice());
        System.out.println(laptopsAndNotebooksPage.beforeSortTheProductsByPrice());
        System.out.println(laptopsAndNotebooksPage.afterSortingTheProductsByPrice());
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //Select Currency
        homePage.selectRequiredCurrency();
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        topMenuPage.hoverOverMainMenuBar("Laptops & NoteBooks");
        //2.2 Click on “Show All Laptops & Notebooks”
        topMenuPage.selectMenu("Show All Laptops & Notebooks");
        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.sortByPriceHigToLow();
        //2.4 Select Product “MacBook”
        Thread.sleep(1500);
        laptopsAndNotebooksPage.selectAProduct("MacBook");
        //2.5 Verify the text “MacBook”
        Assert.assertEquals(productSelectionPage.getSelectedProductName(), "MacBook");
        //2.6 Click on ‘Add To Cart’ button
        productSelectionPage.clickAddToCartButton();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertEquals(productSelectionPage.getsuccessMessageAfterClickingAddToCartButton(), "Success: You have added MacBook to your shopping cart!\n" +
                "×");
        //2.8 Click on link “shopping cart” display into success message
        productSelectionPage.clickShoppingCartButtonInMessage();
        //2.9 Verify the text "Shopping Cart"
        Assert.assertEquals(shoppingCartPage.getShoppingCartTextOnSHoppingCartPage(), "Shopping Cart  (0.00kg)", "Shopping cart message didn't displayed");
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(shoppingCartPage.getProductNameInCart(), "MacBook", "Product name is wrong");
        //2.11 Change Quantity "2" and 2.12 Click on “Update” Tab
        shoppingCartPage.updateQuantity("2");
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertEquals(shoppingCartPage.getShoppingCartUpdatedMessage(), "Success: You have modified your shopping cart!\n" + "×");
        //2.14 Verify the Total £737.45
        Assert.assertEquals(shoppingCartPage.getTotalPriceOfProducts(), "£737.45", "Total price is wrong");
        //2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckOutButton();
        Thread.sleep(1000);
        //2.16 Verify the text “Checkout”
        Assert.assertEquals(checkoutPage.getCheckOutPageText(), "Checkout");
        //2.17 Verify the Text “New Customer”
        Assert.assertEquals(checkoutPage.getNewCustomerText(), "New Customer");
        //2.18 Click on “Guest Checkout” radio button
        checkoutPage.clickOnGuestCheckout();
        //2.19 Click on “Continue” tab
        checkoutPage.clickOnContinueButton();
        //2.20 Fill the mandatory fields
        checkoutPage.sendTextToFirstNameField("Prime");
        checkoutPage.sendTextToLastNameField("Testing");
        checkoutPage.sendTextToEmailField("prime");
        checkoutPage.sendTextToTelephoneField("020876579");
        checkoutPage.sendTextToAddressField("1 Street");
        checkoutPage.sendTextToCityField("London");
        checkoutPage.sendTextToPostCOdeField("L1 2B");
        checkoutPage.selectCountry("United Kingdom");
        checkoutPage.selectRegion("Greater London");
        Thread.sleep(500);
        //2.21 Click on “Continue” Button
        checkoutPage.clickOnGuestContinueButton();
        //2.22 Add Comments About your order into text area
        checkoutPage.sendTextToAddCommentBox("Please wrap the product");
        //2.23 Check the Terms & Conditions check box
        checkoutPage.clickOnTermAndConditionsCheckBox();
        //2.24 Click on “Continue” button
        checkoutPage.clickOnContinueButtonInCommentSection();
        //2.25 Verify the message “Warning: Payment method required!”
        Assert.assertEquals(checkoutPage.getPaymentErrorMessage(), "Warning: No Payment options are available. Please contact us for assistance!");
    }
}