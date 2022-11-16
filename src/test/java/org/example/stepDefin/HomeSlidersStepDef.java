package org.example.stepDefin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.P03_HomePage;
import org.example.pages.P08_ShoesPage;
import org.testng.Assert;

public class HomeSlidersStepDef {

    P03_HomePage p02HomePage;
    P08_ShoesPage p08ShoesPage;

    @And("user hover on apparel category")
    public void userHoverOnAppearlCategory() {
        p02HomePage = new P03_HomePage(Hooks.driver);
        p02HomePage.hoverOnapparelCat();
    }

    @And("user click on shoes category")
    public void userClickOnShoesCategory() {
        p02HomePage.clickOnShoesCat();
    }

    @And("user change color to red")
    public void userChangeColorToRed() {
        p08ShoesPage = new P08_ShoesPage(Hooks.driver);
        p08ShoesPage.selectRedColor();
    }

    @Then("shoes with red color only should appear to the user")
    public void shoesWithRedColorOnlyShouldAppearToTheUser() {
        Assert.assertTrue(p08ShoesPage.isRedColorSelected());
    }

}
