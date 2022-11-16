package org.example.stepDefin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.P03_HomePage;
import org.testng.Assert;

public class HoverCategoriesStepDef {

    P03_HomePage p02HomePage;

    @And("user hover on electronic category")
    public void userHoverOnElectronicCategory() {
        p02HomePage = new P03_HomePage(Hooks.driver);
        p02HomePage.hoverOnElectronicsCat();
    }

    @And("user click on cellPhone category")
    public void userClickOnCellPhoneCategory() {
        p02HomePage.clickOnCellPhoneCat();
    }

    @Then("cell phones page should appear to the user")
    public void cellPhonesAppear() {
        String expectedUrl = "https://demo.nopcommerce.com/cell-phones";
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), expectedUrl);
    }

}
