package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ProductSelectionPage;
import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopsTest extends BaseTest {

    //Creating object of related classes
    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();
    ProductSelectionPage productSelectionPage = new ProductSelectionPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();


    @Test
    public void verifyProductsAreArrangedInAlphabeticalOrder() {
        homePage.hoverOverDesktopLink();
        homePage.clickOnShowAllDesktopsLink();
        desktopsPage.sortByZtoA();
        Assert.assertEquals(desktopsPage.beforeSortTheProducts(), desktopsPage.afterSortingTheProducts());
    }

    @Test
    public void verifyProductAreAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Currency
        homePage.selectRequiredCurrency();
        //2.1
        homePage.hoverOverDesktopLink();
        //2.2
        homePage.clickOnShowAllDesktopsLink();
        //2.3
        desktopsPage.sortByAtoZ();
        Assert.assertEquals(desktopsPage.beforeSortTheProducts(),desktopsPage.afterSortingTheProducts());
        //2.4
        desktopsPage.clickOnHpLPDesktop();
        //2.5
        Assert.assertEquals(productSelectionPage.getSelectedProductName(), "HP LP3065", "Product is not displayed on Page");
        //2.6
        productSelectionPage.selectDateAndYearOnCalendar("November", "2022");
        productSelectionPage.selectDateOnCalendar("30");
        //2.7
        productSelectionPage.enterQuantityRequired("1");
        //2.8
        Thread.sleep(1000);
        productSelectionPage.clickAddToCartButton();
        Thread.sleep(1000);
        //2.9
        Assert.assertEquals(productSelectionPage.getsuccessMessageAfterClickingAddToCartButton(), "Success: You have added HP LP3065 to your shopping cart!\n" + "×");
        //2.10
        productSelectionPage.clickShoppingCartButtonInMessage();
        //2.11
        Assert.assertEquals(shoppingCartPage.getShoppingCartTextOnSHoppingCartPage(), "Shopping Cart  (1.00kg)", "Shopping cart message didn't displayed");
        //2.12
        Assert.assertEquals(shoppingCartPage.getProductNameInCart(), "HP LP3065", "Product name is wrong");
        //2.13 Verify the Delivery Date "2022-11-30"
        Assert.assertEquals(shoppingCartPage.getDeliveryDateInCart(), "Delivery Date: 2022-11-30", "Delivery date is wrong");
        //2.14
        Assert.assertEquals(shoppingCartPage.getModelNameInCart(), "Product 21", "Product model is wrong");
        //2.15
        Assert.assertEquals(shoppingCartPage.getTotalPriceOfProducts(), "£74.73", "Total price is wrong");

    }

}
