package org.example.stepDefin;

import io.cucumber.java.en.Given;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageStepDef {

    P03_HomePage homePage;
  //  RegistrationPage registrationPage;

    @Given("user navigate to home page")
    public void openHomePage() {
        homePage = new P03_HomePage(Hooks.driver);
        homePage.openHomePage();
    }
}
