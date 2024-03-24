package Tests;

import com.google.common.io.Files;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
        Dimension dimension=new Dimension(1024,768);
        driver.manage().window().setSize(dimension);
    }

    @AfterMethod
    public void recordFailureTest(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/ScreenShots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.getStackTrace();
            }
        }

    }}
