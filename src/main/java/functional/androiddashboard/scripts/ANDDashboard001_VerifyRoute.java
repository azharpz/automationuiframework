package functional.androiddashboard.scripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Base.AndroidLaunch;
import Base.BaseTest;
import functional.androiddashboard.pages.ANDDashboard;
import functional.dashboard.pages.Dashboard;
import functional.login.pages.Login;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

@Test
public class ANDDashboard001_VerifyRoute extends AndroidLaunch{


	@Test

	public  void reviewRouteDetails() throws IOException, InterruptedException, AWTException 
    {
		AndroidDriver<AndroidElement> driver = capabilities();

		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		// WebDriver driver=capabilities();
		ANDDashboard androiddashboard = PageFactory.initElements(driver, ANDDashboard.class);
		
		ANDDashboard.fromCity(driver);
		ANDDashboard.toCity(driver);
    }
	
	

}

