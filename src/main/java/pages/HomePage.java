package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class HomePage extends BasePage {
    public HomePage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private Actions actions = new Actions(driver);

    @FindBy(xpath = "//*[@test-id='terms_of_use']")
    private WebElement termsOfUse;
    @FindBy(xpath = "//*[@test-id='products']/parent::h4/parent::div")
    private WebElement plansLinks;
    @FindBy(xpath = "//*[@class='visible-xs sub-sub-nav-header']")
    private List<WebElement> testPrepLinks;
    @FindBy(xpath = "//*[@test-id='courses']")
    private WebElement coursesDD;
    @FindBy(xpath = "//*[text()='Popular Tests']")
    private WebElement popularTestsLink;
    @FindBy(partialLinkText = "SAT")
    private WebElement SATLink;


    public HomePage clickSATLink() {
        wait.until(ExpectedConditions.visibilityOf(SATLink));
        SATLink.click();
        return this;
    }

    public HomePage moveToPopularTestsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(popularTestsLink));
        actions.moveToElement(popularTestsLink).perform();
        return this;
    }

    public HomePage scrollIntoViewTermsOfUse() {
        scrollIntoView(termsOfUse);
        return this;
    }

    public int plansLinksAmount() {
        return plansLinks.findElements(By.tagName("li")).size();
    }

    public HomePage moveCourserToCoursesDD() {
        actions.moveToElement(coursesDD).perform();
        return this;
    }

    public int testPrepLinksAmount() {
        return testPrepLinks.size();
    }


}
