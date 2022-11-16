package org.example.stepDefin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.P09_ShoppingCartPage;
import org.testng.Assert;

public class CreateOrderStepDef {

    P09_ShoppingCartPage p09ShoppingCart;

    @And("user complete order")
    public void userCompleteOrder() throws InterruptedException {
        p09ShoppingCart = new P09_ShoppingCartPage(Hooks.driver);
        p09ShoppingCart.completeOrder();
    }

    @Then("order placed successfully")
    public void orderPlacedSuccessfully() {
        Assert.assertEquals(p09ShoppingCart.getShoppingCartTitle(), "Thank you");
        String url = "https://demo.nopcommerce.com/checkout/completed";
        Assert.assertEquals(p09ShoppingCart.getShoppingCartUrlWhenOrderComplete(),url);
    }

}
