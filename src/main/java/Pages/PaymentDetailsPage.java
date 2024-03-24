package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentDetailsPage {
    By UPI_QrBtn=By.xpath("/html/body/div[2]/div[2]/div/div[3]/div[4]/form/div[2]/div[1]/div[1]/div[1]/div/div/div[2]/div/button[1]");
    By cardBtn=By.xpath("//button[@method='card']");
    By netBankingBtn=By.xpath("//button[@method='netbanking']");
    By walletBtn=By.xpath("//button[@method='wallet']");
    By UPI_IDBtn=By.id("upi-collect-list");
    By enterUpID=By.xpath("//input[@name='vpa-upi']");
    By backBtn=By.xpath("(//div[@id='header-wrapper']//div//div//span)[1]");
    By creditNumberField=By.xpath("//input[@name='card[number]']");
    By selectBank=By.xpath("//label[@for='bank-radio-HDFC']");
    By selectWalletType=By.id("wallet-radio-amazonpay");
    By iFrame=By.xpath("/html/body/div[1]/iframe");
    WebDriver driver;
    JavascriptExecutor js;

    public PaymentDetailsPage(WebDriver driver){
        this.driver=driver;
        js= (JavascriptExecutor) driver;
    }
     public void switchToIFrame(){
        driver.switchTo().frame(driver.findElement(iFrame));
     }
    @Step("fill payment data")
    public void fillPaymentData(String UpID, String CCNo){
        driver.switchTo().frame(driver.findElement(iFrame));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //form[@id='form']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(UPI_QrBtn));
        js.executeScript("arguments[0].click()",driver.findElement(UPI_QrBtn));
        driver.findElement(UPI_IDBtn).click();
        driver.findElement(enterUpID).sendKeys( UpID);
        driver.findElement(backBtn).click();
        driver.findElement(cardBtn).click();
        driver.findElement(creditNumberField).sendKeys(CCNo);
        driver.findElement(backBtn).click();
        driver.findElement(netBankingBtn).click();
        driver.findElement(selectBank).click();
        driver.findElement(backBtn).click();
        driver.findElement(walletBtn).click();
        driver.findElement(selectWalletType).click();
        driver.findElement(backBtn).click();

    }
}
