package step_definitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;

import static utilities.DriverSetup.getDriver;

public class LoginFeatureStep {
    LoginPage loginPage = new LoginPage();
    @Given("User should be on the login screen")
    public void userShouldBeOnTheLoginScreen() {
        loginPage.loadAWebPage(loginPage.loginPageURL);
    }

    @When("User enter valid username and password")
    public void userEnterValidUsernameAndPassword() {
        loginPage.writeOnAElement(loginPage.emailInputBox, "standard_user");
        loginPage.writeOnAElement(loginPage.passwordInputBox, "secret_sauce");
    }

    @And("User click on the login button")
    public void userClickOnTheLoginButton() {
        loginPage.clickOnElement(loginPage.loginButton);
    }

    @Then("User should be navigate to the inventory page")
    public void userShouldBeNavigateToTheInventoryPage() {
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @But("User should not be on the login page")
    public void userShouldNotBeOnTheLoginPage() {
        Assert.assertFalse(getDriver().getCurrentUrl().equals(loginPage.loginPageURL));
    }

    @When("User enter {string} on the username filed")
    public void userEnterOnTheUsernameFiled(String username) {
        loginPage.writeOnAElement(loginPage.emailInputBox, username);

    }

    @And("User enter {string} on the password filed")
    public void userEnterOnThePasswordFiled(String arg0) {
        loginPage.writeOnAElement(loginPage.passwordInputBox, arg0);
    }

    @Then("User should see {string} error message")
    public void userShouldSeeErrorMessage(String arg0) {
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMsg), arg0);
    }
}
