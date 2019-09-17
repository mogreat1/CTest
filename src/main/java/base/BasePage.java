package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait){
        this.driver = driver;
        this.js = js;
        this.wait = wait;
    }

    protected void scrollIntoView(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
