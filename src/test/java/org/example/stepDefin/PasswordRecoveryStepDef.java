package org.example.stepDefin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.P02_Login;
import org.example.pages.P04_PasswordRecoveryPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PasswordRecoveryStepDef {

    P02_Login p03LoginPage;
    P04_PasswordRecoveryPage p04_passwordRecoveryPage;

    @And("user clicked on forgot password")
    public void userClickedOnForgotPassword() {
        p03LoginPage = new P02_Login(Hooks.driver);
        p03LoginPage.clickForgetPassword();
    }

    @And("user entered email for reset password")
    public void userEnteredEmailForResetPassword() {
        p04_passwordRecoveryPage = new P04_PasswordRecoveryPage(Hooks.driver);
        p04_passwordRecoveryPage.enterEmail("Ahmed@service.com");
    }

    @And("user clicked on recover button")
    public void userClickedOnRecoverButton() {
        p04_passwordRecoveryPage.clickOnRecoverBtn();
    }

    @Then("user should have a success message for recover")
    public void userShouldHaveASuccessMessageForRecover() {
        String resetMessage = Hooks.driver.findElement(By.xpath("//div[@class=\"bar-notification success\"]")).getText();
        Assert.assertEquals(resetMessage, "Email with instructions has been sent to you.");
    }

}
