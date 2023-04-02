package functional.dashboard.scripts;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Base.BaseTest;
import functional.dashboard.pages.Dashboard;
import functional.login.pages.Login;

@Test
public class Dashboard001_SearchTruck extends BaseTest{


	@Test

	public  void searchTruck() throws IOException, InterruptedException, AWTException 
    {
	
		// WebDriver driver=capabilities();
		 Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
		 Login login = PageFactory.initElements(driver, Login.class);

		
		 dashboard.selectFromCity();
		 dashboard.selectToCity();
		 dashboard.pickupDate(driver);
		 dashboard.truckcategory(driver);
		 dashboard.truckWeight(driver);
		 dashboard.searchTruck(driver);
		 login.enterLoginDetail();
		 		
    }
	
	

}

