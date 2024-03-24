package Tests;

import DataDriven.ReadJson;
import Pages.PaymentDetailsPage;
import Pages.SelectSeatPage;
import Pages.ksrtcHomePage;
import org.testng.annotations.Test;

public class BookSeatTest extends BaseTest {
    ksrtcHomePage ksrtcHomePage;
    SelectSeatPage selectSeatPage;
    PaymentDetailsPage paymentDetailsPage;
    ReadJson readJson;
    String customerMobileNo;
    String customerEmail;
    String passengerName;
    String passengerAge;
    String MobileNo;
    String ccNo;



    @Test
    public void bookSeat()  {
      readJson = new ReadJson();
      customerMobileNo =  readJson.getJsonValue("resources/BookSeatData.json" , "CustomerMobileNo");
      customerEmail =  readJson.getJsonValue("resources/BookSeatData.json" , "CustomerEmail");
      passengerName =  readJson.getJsonValue("resources/BookSeatData.json" , "PassName");
      passengerAge =  readJson.getJsonValue("resources/BookSeatData.json" , "PassAge");
      MobileNo=readJson.getJsonValue("resources/BookSeatData.json" , "MobileNo");
      ccNo= readJson.getJsonValue("resources/BookSeatData.json" , "ccNo");

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
      paymentDetailsPage=selectSeatPage.clickMakePaymentBtn();
      paymentDetailsPage.fillPaymentData(MobileNo,ccNo);
    }
}
