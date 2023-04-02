package functional.dashboard.pages;

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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import functional.dashboard.pageobjects.DashboardPageObjects;
import util.ExtentHTMLReporter;

/**
 * Object/UI interactions for the Landing page.<br>
 * <br>
 * Holds multiple methods for the landing page header navigation, search, etc.
 */
public class Dashboard extends DashboardPageObjects {
	ExtentTest Test = extent.createTest("Dashboard");

	/**
	 * Create new LandingPage object with the given driver.<br>
	 * <br>
	 * Driver is passed through to the backing object class.
	 * 
	 * @param driver active driver to use for this page
	 */

	static Logger log = Logger.getLogger(Dashboard.class.getName());

	public Dashboard(WebDriver driver) {

		super(driver);
	}

	/**
	 * Selects the 'MY ACCOUNT' option from the header navigation ribbon.<br>
	 * <br>
	 * This is expected to display the list of options directly below (no page
	 * navigation).
	 * @throws IOException
	 */

	public void selectFromCity() throws IOException {
		//ExtentTest Test = extent.createTest("FromCity");

		selectfromcity.sendKeys(getfromcity());

		if (selectfromcity.isEnabled()) {
			// System.out.println("Select city text area open");

			log.info("Text field is enable to search route");
			Test.info("Text field is enable to search route");
			

		} else {
			// System.out.println("Select city text area does not open");
			log.error("Text field is enable to search route");

			// Test.fail("Select city text area does not
			// open",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\user\\eclipse-workspace\\ui-test-automation\\reports\\AutomationReport.html").build());

		}

		List<WebElement> fromcity = googlefromlist;

		Iterator<WebElement> itr = fromcity.iterator();
		int i = 1;
		String value = "";
		while (itr.hasNext()) {
			WebElement element = itr.next();
			value = element.getText();
			// System.out.println("name of city displaying in suggestion list as " + value);
			log.info("name of city displaying in suggestion list as   " + value);

		}

		int fromcitycount = fromcity.size();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("no of fromcity is " + fromcitycount);

		fromcity.get(fromcitycount - 1).click();
		log.info("From route selected ");
		Test.pass("From route selected ");
	}

	public void selectToCity() throws IOException {

		//ExtentTest Test = extent.createTest("ToCity");

		selecttocity.sendKeys(gettocity());

		if (selecttocity.isEnabled()) {
			// System.out.println("Select city text area open");
			log.info("Text field is enable to search route");

			Test.info("Text field is enable to search route");

		} else {
			// System.out.println("Select city text area does not open");
			log.error("Text field is not enable to search route");
			Test.fail("Text field is not enable to search route");

		}

		List<WebElement> tocity = googletolist;

		Iterator<WebElement> itr = tocity.iterator();
		int i = 1;
		String value = "";
		while (itr.hasNext()) {
			WebElement element = itr.next();
			value = element.getText();
			// System.out.println("name of city displaying in suggestion list as " + value);
			log.info("name of city displaying in suggestion list as  " + value);
			//Test.info("name of city displaying in suggestion list as  " );


		}

		int tocitycounts = tocity.size();
		// System.out.println("no of tocity is " + tocitycounts);
		tocity.get(tocitycounts - 1).click();
		log.info("To route selected ");
		Test.pass("To route selected ");

	}

	public void truckcategory(WebDriver driver) throws InterruptedException

	{
		
		selecttruckcategory.click();
		log.info("Truck Category list open");
		Test.info("Truck Category list open");
		Thread.sleep(3000);

		List<WebElement> truck = truckcategorylist;
		Iterator<WebElement> itr = truck.iterator();
		int i = 1;
		String value = "";
		while (itr.hasNext()) {
			WebElement element = itr.next();
			value = element.getText();
			// System.out.println("name of truck displaying in dropdown as " + value);
			log.info("name of truck displaying in dropdown as   " + value);
			Test.info("name of truck displaying in dropdown as   " + value);


		}

		int trucktypes = truckcategorylist.size();

		//System.out.println("no of truck displaying is   " + trucktypes);
		log.info("no of truck displaying is   " + trucktypes);
		Test.info("no of truck displaying is   " + trucktypes);


		truckcategorylist.get(1).click();

		log.info("Truck Category Selected as " +truckcategorylist.get(1).getText());
		Test.pass("Truck Category Selected as " +truckcategorylist.get(1).getText());


	}

	private void reportVP(String string, String pass, String string2) {
		// TODO Auto-generated method stub

	}

	public void truckWeight(WebDriver driver) throws InterruptedException

	{

		selectweight.click();
		log.info("weightlist list open");
		Test.info("weightlist list open");

		Thread.sleep(3000);

		List<WebElement> weight = weightlist;
		Iterator<WebElement> itr = weight.iterator();
		int i = 1;
		String value = "";
		while (itr.hasNext()) {
			WebElement element = itr.next();
			value = element.getText();
			// System.out.println("name of truckwight displaying in list as " + value);
			log.info("name of truckwight displaying in list as  " + value);
			Test.info("name of truckwight displaying in list as  " + value);

		}

		int truckweight = weightlist.size();

		// System.out.println("no of truckweight as displayed " + truckweight);
		log.info("no of truckweight as displayed " + truckweight);
		Test.info("no of truckweight as displayed " + truckweight);


		weightlist.get(1).click();
		log.info("weight selected");
		Test.pass("weight selected");


	}

	public void pickupDate(WebDriver driver) throws InterruptedException, IOException

	{

		driver.findElement(By.xpath("//input[@id='mat-input-2']")).click();
		log.info("Date picker open");
		Test.info("Date picker open");

		Thread.sleep(3000);
		List<WebElement> dates = datelist;
		int count = datelist.size();

		for (int j = 0; j < count; j++) {
			String texts = datelist.get(j).getText();

			if (texts.equalsIgnoreCase("2")) {
				driver.findElements(By.xpath("//button[contains(@aria-pressed,'false')]")).get(j).click();
				log.info("Date Selected");
				Test.pass("Date Selected");
				break;
				
			}
			

		}

	}

	public void pickuptoday(WebDriver driver) throws InterruptedException, IOException

	{

		driver.findElement(By.xpath("//input[@id='mat-input-2']")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//div[@class='mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today']"))
				.click();
		log.info("date selected");
		Test.pass("date selected");



	}

	public void searchTruck(WebDriver driver) throws InterruptedException

	{

		
		   if(searchtruck.isEnabled()){
			   searchtruck.click(); 
			   
			   
			   log.info(" Redireccted to login page to get quote");
			   Test.pass(" Redireccted to login page to get quote");
			   
		    } else
		    	
		    { 
		    	//System.out.println("not Redireccted to login page");
		    	 log.error(" not Redireccted to login page to get quote");
				   Test.fail(" not Redireccted to login page to get quote");
				   
		    }	 
		  Thread.sleep(6000); 
		 
	}
	
	public void clickLogin() throws IOException, InterruptedException{
		
	    
		 login.click();
		

			if(login.getText().contains("Login")){
				//System.out.println("otp page open");
				log.info("User navigates to login page");
				Test.pass("User navigates to login page");
				  
			}
			else{
				log.error("User not navigates to login page");
				Test.fail("User not navigates to login page");

				  
			}
			
	
	}
	
	public void clickProfileList() throws IOException, InterruptedException{
		
	    
		profilelist.click();
		

			if(profilelist.isEnabled()){
				//System.out.println("otp page open");
				log.info("List option opens");
				Test.pass("List option opens");
				  
			}
			else{
				log.error("List option not opens");
				Test.fail("List option not opens");

				  
			}
			
	
	}
	
public void clickTrips() throws IOException, InterruptedException{
		
	    
	         trips.click();
		
			
	
	}
	

}
