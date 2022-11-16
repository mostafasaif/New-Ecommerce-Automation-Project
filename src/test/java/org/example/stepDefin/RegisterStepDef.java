package org.example.stepDefin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegisterStepDef {

    P03_HomePage homePage;
    P01_Register registrationPage;

    @And("user clicked on register link")
    public void clickOnRegisterButton() {
        homePage = new P03_HomePage(Hooks.driver);
        homePage.registerClick();
    }

    @When("user selected gender")
    public void selectGender(){
        registrationPage = new P01_Register(Hooks.driver);
        registrationPage.setGender("male");
    }

    @And("user entered first name")
    public void enterFirstName(){
        registrationPage.setFirstName("Mostafa");
    }
    @And("user entered last name")
    public void enterLastName(){
        registrationPage.setLastName("Mohamed");
    }

    @And("user selected birth of date")
    public void enterBirthOfDate(){
        registrationPage.setDayOfBirth(1);
        registrationPage.setMonthOfBirth("september");
        registrationPage.setYearOfBirth(1997);
    }

    @And("user entered email for registration")
    public void enterEmail(){
        registrationPage.setEmail("mostafasaif199@gmail.com");
    }
    @And("user entered company name")
    public void enterCompanyName(){
        registrationPage.setCompanyName("ITIDA");
    }
    @And("user entered password for registration")
    public void enterPassword(){
        registrationPage.setPassword("M0stafa");
    }
    @And("user confirmed password for registration")
    public void confirmPassword(){
        registrationPage.confirmPassword("M0stafa");
    }

    @And("user clicked on register button")
    public void userClickedOnRegisterButton() {
        registrationPage.clickRegisterButton();
    }


    @Then("user should have a success message for registration")
    public void userShouldHaveASuccessMessageForRegistration() {
        WebElement registerTitle = Hooks.driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(registerTitle.getText(), "Register");

        String registerMessage = Hooks.driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        Assert.assertEquals(registerMessage, "Your registration completed");
    }

}
