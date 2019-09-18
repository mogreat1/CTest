package base;

import cucumber.api.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    protected WebDriver driver;


    public void setUp(){
        driver = new ChromeDriver();

    }

    public void tearDown(){
        driver.quit();
    }

}
