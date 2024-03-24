package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class ksrtcHomePage {
    private WebDriver driver;
    JavascriptExecutor js;
    By popularRoute =By.id("fromPlaceName");

    By selectPopularRoute=By.xpath("//*[@id='routeSlider']/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/a[1]");
    By sliderButton=By.xpath("//*[@id='routeSlider']/div[1]/a[2]/span[1]");
        By selectDate=By.xpath("//tr //td [7]//a[@class='ui-state-default']");
    By searchButton=By.xpath("//form[@id='bookingsForm']/div[1]/div[1]/div[2]/div[3]/button[1]");

    By coroverCloseBtn=By.xpath("//div[@id='corover-close-btn']");
    public ksrtcHomePage(WebDriver driver){
        this.driver=driver;
        js= (JavascriptExecutor) driver;
    }
    @Step("scroll down to popular routes section")
    public void scrollDown()  {

        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(popularRoute));

    }
    @Step("select popular route")
    public void SelectPopularRoute( ) {
        driver.findElement(sliderButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(selectPopularRoute));
       driver.findElement(selectPopularRoute).click();

    }
    public void selectDate(){
        driver.findElement(coroverCloseBtn).click();
        FluentWait wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(selectDate));
        js.executeScript("arguments[0].click()",driver.findElement(selectDate));
    }
    public SelectSeatPage clickSearchButton()  {
        driver.findElement(searchButton).click();
        driver.findElement(coroverCloseBtn).click();
        return  new SelectSeatPage(driver);
    }


}
