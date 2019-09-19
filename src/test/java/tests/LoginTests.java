package tests;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.net.MalformedURLException;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        super.setUp();
        loginPage = new LoginPage(driver);
        driver.get("https://study.com/academy/login.html");

    }

    @Test(dataProvider = "loginData")
    private void userLoginWithInvalidCredentials(String username, String password){
        loginPage.sendEmail(username).sendPassword(password).clickLoginBtn();
        Assert.assertTrue(loginPage.isLoginErrorDisplayed());
    }

    @DataProvider(name = "loginData")
    public Object[][] credentials(){
        return new Object[][] {{"asdf", "12312"}, {"asdf", "123"}};
    }

}
