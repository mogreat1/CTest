package base;

import docker.Start;
import docker.Stop;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    ThreadLocal<RemoteWebDriver> threadDriver;
    protected RemoteWebDriver driver;


    @BeforeTest
    public void startDockerScale() throws IOException, InterruptedException
    {
        File fi =new File("output.txt");
        if(fi.delete())
        {
            System.out.println("file deleted successfully");
        }
        Start s=new Start();
        s.startFile();
    }

    @AfterTest
    public void stopDockerDeleteFile() throws IOException, InterruptedException
    {
        Stop d=new Stop();
        d.stopFile();

    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap=DesiredCapabilities.chrome();
        URL url=new URL("http://localhost:4444/wd/hub");
        driver=new ThreadLocal<RemoteWebDriver(url,cap)>();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
