package com.cybertek.tests.reviews.week6;

import com.cybertek.pages.adidasPages.CartPage;
import com.cybertek.pages.adidasPages.ProductPage;
import com.cybertek.tests.TestBase2;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AdidasWithPOM extends TestBase2 {

    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Test
    public void test1() throws InterruptedException {
        productPage.navigateTo("Laptops");
        productPage.addProduct("Sony vaio i5");
        productPage.laptopsCategory.click();
        productPage.addProduct("Dell i7 8gb");
        productPage.laptopsCategory.click();
        productPage.addProduct("MacBook air");
        productPage.navigateTo("Cart");
        productPage.removeItem("MacBook air");
        productPage.removeItem("Dell i7 8gb");
        Thread.sleep(2000);
        cartPage.placeOrderButton.click();
        cartPage.fillForm();
        cartPage.purchaseButton.click();
        productPage.verifyPrice(productPage.getExpectedBill(),productPage.getActualPrice());


    }


}
