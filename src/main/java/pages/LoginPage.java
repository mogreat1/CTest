package pages;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
        super(driver, js, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "emailAddress")
    private WebElement emailField;
    @FindBy(id = "pwd")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@test-id='login_page_login_button']")
    private WebElement loginBtn;
    @FindBy(className = "loginError")
    private WebElement loginError;


    public LoginPage sendEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage sendPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginBtn() {
        loginBtn.click();
        return this;
    }

    public boolean isLoginErrorDisplayed() {
        return loginError.isDisplayed();
    }

}
