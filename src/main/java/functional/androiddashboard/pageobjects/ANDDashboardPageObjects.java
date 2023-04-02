package functional.androiddashboard.pageobjects;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Base.BaseTest;
import functional.dashboard.pages.Dashboard;
import util.ExtentHTMLReporter;

/**
 * Abstract superclass containing object definitions for LandingPageObjects (Web objects).
 * This class is intended for extension by a script or any class supporting object actions.<br><br>
 * <em>File contents are auto-generated - any changes made to this file will be overwritten
 * by a subsequent update to the corresponding object file via the Object Map.</em>
 */
public abstract class ANDDashboardPageObjects extends BaseTest {
	
	

	
	public ANDDashboardPageObjects(WebDriver driver){
		BaseTest.driver=driver;
		
		PageFactory.initElements(driver,this); 
		
	}

	
	
	
	@FindBy(how=How.XPATH,using="//span[@class='right-top-area']") 
	protected
	WebElement pickupdates;
	
	@FindBy(how=How.XPATH,using="(//p[@class='m-0 color-black'])[2]") 
	protected
	WebElement truckweight;
	
	@FindBy(how=How.XPATH,using="(//p[@class='m-0 color-black'])[1]") 
	protected
	WebElement truckfeet;
	
	@FindBy(how=How.XPATH,using="//span[@class='truckPrice-area']") 
	protected
	WebElement truckprice;
	
	@FindBy(how=How.XPATH,using="//div[contains(@class,'col-md-9')]") 
	protected
	WebElement truckselection;
	
	
	@FindBy(how=How.XPATH,using="/html/body/app-root/app-truck-details/div/form/div/div[2]/button") 
	protected
	WebElement ProceedNext;
	
	
	
	
	public Properties getpropertyObject() throws IOException
	{
		
	FileReader reader=new FileReader("C:\\Users\\user\\eclipse-workspace\\RobustFramework2\\src\\main\\java\\functional\\dashboard\\data\\Dashboard.properties");  
	      
	    Properties p=new Properties();  
	    p.load(reader);  
	    
	    return p;
	    
	   }




	public  String getfromcity() throws IOException
	{
		return getpropertyObject().getProperty("fromcity");
	}

	public  String gettocity() throws IOException
	{
		return getpropertyObject().getProperty("tocity");
	}
	
	public  String getdate() throws IOException
	{
		return getpropertyObject().getProperty("PickDate");
	}

		}


