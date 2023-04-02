package functional.bookingdetails.scripts;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Base.BaseTest;
import functional.bookingdetails.pages.BookingDetails;
import functional.dashboard.pages.Dashboard;
import functional.login.pages.Login;

@Test
public class BookingDetails001_VerifyBookingDetails extends BaseTest{


	@Test

	public  void reviewBookingDetails() throws IOException, InterruptedException, AWTException 
    {
	
		// WebDriver driver=capabilities();
		 Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		 Login login = PageFactory.initElements(driver, Login.class);
		 BookingDetails bookingdetails = PageFactory.initElements(driver, BookingDetails.class);




		
		 dashboard.selectFromCity();
		 dashboard.selectToCity();
		 dashboard.pickupDate(driver);
		 dashboard.truckcategory(driver);
		 dashboard.truckWeight(driver);
		 dashboard.searchTruck(driver);
		 login.enterLoginDetail();
		 Thread.sleep(5000);
		 bookingdetails.getpickupCity();
		 bookingdetails.getdropoffCity();
		 bookingdetails.getPickupDate(driver);
		 bookingdetails.gettruckWeight(driver);
		 Thread.sleep(2000);
		 bookingdetails.proceedNext(driver);
		 
		 		
    }
	
	

}

