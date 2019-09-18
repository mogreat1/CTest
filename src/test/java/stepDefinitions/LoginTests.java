package stepDefinitions;


import base.BaseTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    @Given("^User is on Login page$")
    public void user_is_on_login_page() throws Throwable {
        setUp();
        loginPage = new LoginPage(driver);
        driver.get("https://study.com/academy/login.html");
    }

    @When("^User login with valid (.+) and (.+)$")
    public void user_login_with_valid_and(String username, String password) throws Throwable {
        loginPage.sendEmail(username).sendPassword(password).clickLoginBtn();
    }

    @Then("^User is logged in$")
    public void user_is_logged_in() throws Throwable {
        Assert.assertTrue(loginPage.isLoginErrorDisplayed());

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
