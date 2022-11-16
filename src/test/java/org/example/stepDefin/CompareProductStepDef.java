package org.example.stepDefin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.P06_BookPage;
import org.example.pages.P07_CompareProductPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CompareProductStepDef {

    P06_BookPage p06BookPage;
    P07_CompareProductPage comparePage;


    @And("user add items to compare list")
    public void userAddItemsToCompareList() {
        p06BookPage = new P06_BookPage(Hooks.driver);
        p06BookPage.addItemsToCompare();
    }

    @And("user navigate to compare list")
    public void userNavigateToCompareList() {
        p06BookPage.openComparePage();
    }

    @Then("added items should appear at compare list")
    public void addedItemsShouldAppearAtCompareList() {
        comparePage = new P07_CompareProductPage(Hooks.driver);
        Assert.assertEquals(comparePage.getCompareListTitle(), "Compare products");

        List<WebElement> itemsName = comparePage.getItemNames();
        Assert.assertEquals(itemsName.get(0).getText(),"Fahrenheit 451 by Ray Bradbury");
        Assert.assertEquals(itemsName.get(1).getText(),"First Prize Pies");
        Assert.assertEquals(itemsName.get(2).getText(),"Pride and Prejudice");
    }

}
