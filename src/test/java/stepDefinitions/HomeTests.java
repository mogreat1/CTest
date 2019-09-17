package stepDefinitions;

import base.BaseTest;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.SATPage;

public class HomeTests extends BaseTest {
    private HomePage homePage;
    private SATPage satPage;

    @When("^User move courser to Popular Tests DD$")
    public void user_move_courser_to_Popular_Tests_DD() throws Throwable {
        homePage.moveToPopularTestsLink();
    }

    @When("^User click SAT test link$")
    public void user_click_SAT_test_link() throws Throwable {
        homePage.clickSATLink();
    }

    @Then("^Page title contains SAT$")
    public void page_title_contains_SAT() throws Throwable {
        Assert.assertTrue(satPage.getPageTitle().contains("SAT"));
    }

    @When("^User move courser to the Courses DD$")
    public void user_move_courser_to_the_Courses_DD() throws Throwable {
        homePage.moveCourserToCoursesDD();
    }

    @Then("^Four Test Prep links are displayed$")
    public void four_Test_Prep_links_are_displayed() throws Throwable {
        Assert.assertEquals(homePage.testPrepLinksAmount(), 4);
        tearDown();
    }

    @Given("^User is on Home page$")
    public void user_is_on_Home_page() throws Throwable {
        setUp();
        homePage = new HomePage(driver, js, wait);
        satPage = new SATPage(driver, js, wait);
        driver.get("https://study.com/");
    }

    @When("^User scrolls into view to the footer$")
    public void user_scrolls_into_view_to_the_footer() throws Throwable {
        homePage.scrollIntoViewTermsOfUse();
    }

    @Then("^He sees four types of planes$")
    public void he_sees_four_types_of_planes() throws Throwable {
        Assert.assertEquals(homePage.plansLinksAmount(), 4);
        tearDown();
    }


}
