package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SATPage;

import java.net.MalformedURLException;

public class HomeTests extends BaseTest {
    private HomePage homePage;
    private SATPage satPage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        super.setUp();
        homePage = new HomePage(driver);
        satPage = new SATPage(driver);
        driver.get("https://study.com/");
    }

    @Test
    private void test() {
        homePage.moveCourserToCoursesDD();
        homePage.moveToPopularTestsLink();
        homePage.clickSATLink();
        Assert.assertTrue(satPage.getPageTitle().contains("SAT"));
    }

    @Test
    private void test2() {
        homePage.moveCourserToCoursesDD();
        Assert.assertEquals(homePage.testPrepLinksAmount(), 4);
    }

    @Test
    private void test3() {
        homePage.scrollIntoViewTermsOfUse();
        Assert.assertEquals(homePage.plansLinksAmount(), 4);
    }


}
