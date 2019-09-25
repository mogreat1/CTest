package base;

import docker.Start;
import docker.Stop;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    ThreadLocal<RemoteWebDriver> threadDriver;
    protected RemoteWebDriver driver;


    @BeforeSuite
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

    @AfterSuite
    public void stopDockerDeleteFile() throws IOException, InterruptedException
    {
        Stop d=new Stop();
        d.stopFile();

    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap=DesiredCapabilities.chrome();
        URL url=new URL("http://localhost:4444/wd/hub");
        driver=new RemoteWebDriver(url, cap);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
