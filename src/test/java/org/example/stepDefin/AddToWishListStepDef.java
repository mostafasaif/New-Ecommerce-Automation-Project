package org.example.stepDefin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.P06_BookPage;
import org.example.pages.P11_WishListPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AddToWishListStepDef {

    P06_BookPage p06BookPage;
    P11_WishListPage p11WishListPage;

    @And("user add items to whish list")
    public void userAddItemsToWhishList() {
        p06BookPage = new P06_BookPage(Hooks.driver);
        p06BookPage.addItemsToFav();
    }

    @And("user navigate to whish list")
    public void userNavigateToWhishList() {
        p06BookPage.openWhishListPage();
    }

    @Then("added items should appear at whish list")
    public void addedItemsShouldAppearAtWhishList() {
        p11WishListPage = new P11_WishListPage(Hooks.driver);
        List<WebElement> itemsName = (List<WebElement>) p11WishListPage.getWishListItemNames();
        Assert.assertEquals(itemsName.get(0).getText(),"Fahrenheit 451 by Ray Bradbury");
        Assert.assertEquals(itemsName.get(1).getText(),"First Prize Pies");
        Assert.assertEquals(itemsName.get(2).getText(),"Pride and Prejudice");

        List<WebElement> itemsQty = p11WishListPage.getWishListItemQty();
        int qty = 0;
        for (WebElement qtyElement : itemsQty){
            qty += Integer.parseInt(qtyElement.getAttribute("value"));
        }
        System.out.println("qty : "+qty);
        Assert.assertEquals(qty,3);

        Assert.assertEquals(p11WishListPage.getWishListTitle(), "Wishlist");
    }

}
