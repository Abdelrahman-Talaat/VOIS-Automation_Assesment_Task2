package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectSeatPage {
    By customerDetailsTab=By.xpath("//a[@id='Forwardprofile-tab']");
    By mobileNoLabel=By.xpath("//label[@for='mobileNo']");
    By mobileNoField=By.xpath("//input[@name='mobileNo']");
    By emailIdField=By.xpath("//input[@name='email']");
    By selectSeat=By.xpath("(//li[@class='availSeatClassS'])[10]");
    By checkAgreementsBox=By.xpath("//input[@id='termsChk']");
    By makePaymentBtn=By.id("PgBtn");
    By gender=By.cssSelector("[value='25']");
    By passengerName=By.id("passengerNameForward0");
    By PassengerAge=By.id("passengerAgeForward0");
    By selectConcession=By.xpath("(//option[@value='1466060086837'])[1]");
    By selectSeatButton=By.xpath("//div[@class='select-service']//input[@id='SrvcSelectBtnForward0']");
    WebDriver driver;

    public SelectSeatPage (WebDriver driver){
        this.driver=driver;
    }
    @Step("click on select seats button")
    public void clickSelectSeat(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(selectSeatButton));
        driver.findElement(selectSeatButton).click();
    }

    @Step("navigate to customer details tab")
    public void navigateToCustomerDetailsTab(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(customerDetailsTab));
        driver.findElement(customerDetailsTab).click();
        wait.until(ExpectedConditions.elementToBeClickable(mobileNoLabel));
    }
    @Step("enter customer data")
    public void enterCustomerData(String mobileNo , String email){
        driver.findElement(mobileNoField).sendKeys(mobileNo);
        driver.findElement(emailIdField).sendKeys(email);


    }
    @Step("select seat")
    public void selectSeat(){
        driver.findElement(selectSeat).click();
    }
    public void enterPassengerDetails( String passName , String passAge){
        driver.findElement(passengerName).sendKeys(passName);
        driver.findElement(gender).click();
        driver.switchTo().alert().dismiss();
        driver.findElement(PassengerAge).sendKeys(passAge);
        driver.findElement(selectConcession).click();
    }
    @Step("click on agreement check box")
    public void CheckAgreementsBox(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkAgreementsBox));
        driver.findElement(checkAgreementsBox).click();
    }
    @Step("click on make payment button")
    public PaymentDetailsPage clickMakePaymentBtn(){
        driver.findElement(makePaymentBtn).click();
        return  new PaymentDetailsPage(driver);
    }
}
