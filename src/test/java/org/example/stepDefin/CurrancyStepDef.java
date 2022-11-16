package org.example.stepDefin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CurrancyStepDef {
    P03_HomePage p03_homePage;

    @And("user change currency from usd to euro")
    public void userChangeCurrencyFromUsdToEuro() {
        p03_homePage = new P03_HomePage(Hooks.driver);
        p03_homePage.changeCurrencyFromUsdToEuro();
    }

    @Then("all products shown are in euro")
    public void allProductsShownAreInEuro() {
        List<WebElement> itemsPrice = Hooks.driver.findElements(By.xpath("//div[@class=\"prices\"]/span"));
        String firstItemPrice = itemsPrice.get(0).getText();
        Assert.assertTrue(firstItemPrice.contains("€"));
    }
}
