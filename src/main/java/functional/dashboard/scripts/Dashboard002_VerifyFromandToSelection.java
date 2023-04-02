package functional.dashboard.scripts;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Base.BaseTest;
import functional.dashboard.pages.Dashboard;
@Test


public class Dashboard002_VerifyFromandToSelection extends BaseTest{


	@Test

	public  void searchTodaysTruck() throws IOException, InterruptedException, AWTException 
    {
	
		// WebDriver driver=capabilities();
		 Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);


		
		 dashboard.selectFromCity();
		 dashboard.selectToCity();
		 dashboard.pickuptoday(driver);
		
		 		
    }
	
	

}
