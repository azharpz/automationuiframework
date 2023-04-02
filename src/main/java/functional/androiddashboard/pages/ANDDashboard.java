package functional.androiddashboard.pages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import functional.androiddashboard.pageobjects.ANDDashboardPageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import util.ExtentHTMLReporter;

/**
 * Object/UI interactions for the Landing page.<br>
 * <br>
 * Holds multiple methods for the landing page header navigation, search, etc.
 */
public class ANDDashboard extends ANDDashboardPageObjects{
//	static ExtentTest Test = extent.createTest("ANDDashboard");

	/**
	 * Create new LandingPage object with the given driver.<br>
	 * <br>
	 * Driver is passed through to the backing object class.
	 * 
	 * @param driver active driver to use for this page
	 */

	static Logger log = Logger.getLogger(ANDDashboard.class.getName());

	public ANDDashboard(WebDriver driver) {

		super(driver);
	}

	/**
	 * Selects the 'MY ACCOUNT' option from the header navigation ribbon.<br>
	 * <br>
	 * This is expected to display the list of options directly below (no page
	 * navigation).
	 * 
	 * @throws IOException
	 */

	public static void fromCity(AndroidDriver<AndroidElement> driver) throws IOException

	{
   
		driver.findElementById("com.s9truck.customer:id/layout_pickup_location").click();
			driver.findElementById("com.s9truck.customer:id/places_autocomplete_search_bar").sendKeys("chennai");
			//driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView[1]").click();
			List<AndroidElement>	fromcity= driver.findElementsById("com.s9truck.customer:id/places_autocomplete_list");

			
		//	com.s9truck.customer:id/places_autocomplete_list
			 
			 Iterator<AndroidElement> itr=fromcity.iterator();
			 int i=1;
			 String value="";
			 while(itr.hasNext())
			 {
				 AndroidElement element=itr.next();
				 value=element.getText();
				 System.out.println("name of city is   "  + value);
			 }
				
             int fromcitycount= fromcity.size();

              System.out.println(fromcitycount);

              fromcity.get(fromcitycount-1).click();
              
      		driver.findElementById("com.s9truck.customer:id/btnConfirmLocation").click();

      		if (fromcity.contains("Mumbai")) {
    			// System.out.println("Select city text area open");

    			log.info("dropoff details"+fromcity);
    		//	Test.pass("dropoff details"+fromcity);
    			

    		} else {
    			// System.out.println("Select city text area does not open");
    			log.error("dropoff details not match"+fromcity);
    		//	Test.fail("dropoff details not match"+fromcity);

    	}
	                              
	}
	
	public static void toCity(AndroidDriver driver) throws InterruptedException, IOException

	{
   
		driver.findElementById("com.s9truck.customer:id/txtDropLocation").click();
		driver.findElementById("com.s9truck.customer:id/places_autocomplete_search_bar").sendKeys("Bangalore");
		//driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView[1]").click();
		List<AndroidElement>	tocity= driver.findElementsById("com.s9truck.customer:id/places_autocomplete_list");
		
		
		 
		 Iterator<AndroidElement> itr=tocity.iterator();
		 int i=1;
		 String value="";
		 while(itr.hasNext())
		 {
			 AndroidElement element=itr.next();
			 value=element.getText();
			 System.out.println("name of tocity is   "  + value);
		 }
			
         int fromcitycount= tocity.size();

          System.out.println(fromcitycount);

          tocity.get(fromcitycount-1).click();
    		driver.findElementById("com.s9truck.customer:id/btnConfirmLocation").click();


	}
	
	
}

