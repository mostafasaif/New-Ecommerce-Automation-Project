package org.example.stepDefin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.P02_Login;
import org.example.pages.P06_BookPage;
import org.example.pages.P09_ShoppingCartPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ShoppingCartStepDef {

    P02_Login p03LoginPage;
    P06_BookPage p01BooksPage;
    P09_ShoppingCartPage p09ShoppingCart;

    @And("user navigate to books pages")
    public void userNavigateToBooksPages() {
        p03LoginPage = new P02_Login(Hooks.driver);
        p03LoginPage.clickOnBooksCat();
    }

    @And("user add items to shopping cart")
    public void userAddItemsToShoppingCart() {
        p01BooksPage = new P06_BookPage(Hooks.driver);
        p01BooksPage.addItemsToCart();
    }

    @And("user navigate to shopping cart")
    public void userNavigateToShopingCart() {
        p01BooksPage.openShoppingCartPage();
    }

    @Then("added items should appear at shopping cart")
    public void addedItemsShouldAppearAtShoppingCart() {
        p09ShoppingCart = new P09_ShoppingCartPage(Hooks.driver);
        List<WebElement> itemsName = p09ShoppingCart.getItemsNamesInShoppingCart();
        Assert.assertEquals(itemsName.get(0).getText(),"Fahrenheit 451 by Ray Bradbury");
        Assert.assertEquals(itemsName.get(1).getText(),"First Prize Pies");
        Assert.assertEquals(itemsName.get(2).getText(),"Pride and Prejudice");

        List<WebElement> itemsQty = p09ShoppingCart.getItemsQtyInShoppingCart();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxx" + itemsQty.get(0).getAttribute("value"));
        int qty = 0;
        for (WebElement qtyElement : itemsQty){
            qty += Integer.parseInt(qtyElement.getAttribute("value"));

        }
        System.out.println("qty : "+qty);
        Assert.assertEquals(qty,3);

        Assert.assertEquals(p09ShoppingCart.getShoppingCartTitle(), "Shopping cart");
    }

}
