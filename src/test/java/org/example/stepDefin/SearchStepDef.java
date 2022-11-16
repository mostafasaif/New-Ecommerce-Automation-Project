package org.example.stepDefin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.P03_HomePage;
import org.example.pages.P05_SearchPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchStepDef {

    P03_HomePage p02HomePage;
    P05_SearchPage p05SearchPage;

    @And("user enter name of item to search for")
    public void userEnterNameOfItemToSearchFor() {
        p02HomePage = new P03_HomePage(Hooks.driver);
        p02HomePage.search("laptop");
    }

    @And("user clicked on search button")
    public void userClickedOnSearchButton() {
        p02HomePage.clickOnSearchBtn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user should have products contains the searched word")
    public void userShouldHaveProductsContainsTheSearchedWord() {
        p05SearchPage = new P05_SearchPage(Hooks.driver);
        List<WebElement> searchedItems = p05SearchPage.getSearchedItems();
        Assert.assertEquals(searchedItems.get(0).getText(), "Asus N551JK-XO076H Laptop");
        Assert.assertEquals(searchedItems.get(1).getText(), "Lenovo Thinkpad X1 Carbon Laptop");
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("laptop"));
    }


}
