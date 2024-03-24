package Tests;

import Pages.PaymentDetailsPage;
import Pages.SelectSeatPage;
import Pages.ksrtcHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BookSeatTest extends BaseTest {
    ksrtcHomePage ksrtcHomePage;
    SelectSeatPage selectSeatPage;
    PaymentDetailsPage paymentDetailsPage;
    String customerMobileNo;
    String customerEmail;
    String passengerName;
    String passengerAge;
    ReadJson readJson;
    @Test
    public void bookSeat()  {
      readJson = new ReadJson();
      customerMobileNo =  readJson.getJsonValue("resources/BookSeatData.json" , "CustomerMobileNo");
      customerEmail =  readJson.getJsonValue("resources/BookSeatData.json" , "CustomerEmail");
      passengerName =  readJson.getJsonValue("resources/BookSeatData.json" , "PassName");
      passengerAge =  readJson.getJsonValue("resources/BookSeatData.json" , "PassAge");

      ksrtcHomePage =new ksrtcHomePage(driver);
      ksrtcHomePage.scrollDown();
      ksrtcHomePage.SelectPopularRoute();
      ksrtcHomePage.selectDate();
      selectSeatPage=ksrtcHomePage.clickSearchButton();
      selectSeatPage.clickSelectSeat();
      selectSeatPage.navigateToCustomerDetailsTab();
      selectSeatPage.enterCustomerData(customerMobileNo,customerEmail);
      selectSeatPage.selectSeat();
      selectSeatPage.enterPassengerDetails(passengerName,passengerAge);
      selectSeatPage.CheckAgreementsBox();
      paymentDetailsPage =selectSeatPage.clickMakePaymentBtn();
      paymentDetailsPage.fillPaymentData("6789125987","123456789012");
    }
}
