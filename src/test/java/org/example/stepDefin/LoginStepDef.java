package org.example.stepDefin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.example.pages.P02_Login;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginStepDef {
    P03_HomePage homePage;
    P02_Login loginPage;

    @And("user clicked on login link")
    public void userClickedOnLoginLink() {
        homePage = new P03_HomePage(Hooks.driver);
        homePage.loginClick();
    }

    @And("user entered email for login")
    public void userEnteredEmailForLogin() {
        loginPage = new P02_Login(Hooks.driver);
        loginPage.enterEmail("Ahmed@service.com");
    }

    @And("user entered password for login")
    public void userEnteredPasswordForLogin() {
        loginPage.enterPassword("P@ssWord");
    }

    @And("user clicked on login button")
    public void userClickedOnLoginButton() {
        loginPage.clickLogIn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("user should have a success message for login")
    public void userShouldHaveASuccessMessageForLogin() {

        Assert.assertTrue(Hooks.driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).isDisplayed());
        Assert.assertEquals(Hooks.driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).getText(), "My account");
    }

}
