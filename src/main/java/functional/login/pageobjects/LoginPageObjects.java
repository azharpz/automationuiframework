package functional.login.pageobjects;


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
public abstract class LoginPageObjects extends BaseTest {
	
	
	
	public LoginPageObjects(WebDriver driver){
		BaseTest.driver=driver;
		
		PageFactory.initElements(driver,this); 
		
	}

	

	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Enter email']") 
	protected
	WebElement enteremail;
	
	@FindBy(how=How.XPATH,using="//button[normalize-space()='Sign In']") 
	protected
	WebElement signin;
	
	@FindBy(how=How.XPATH,using="//div[@id='toast-container']") 
	protected
	WebElement verifytoast;
	
	@FindBy(how=How.XPATH,using="//p[@class='mb-5 fw-bold']") 
	protected
	WebElement verifyemail;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Enter password']") 
	protected
	WebElement enterpassword;
	
	@FindBy(how=How.XPATH,using="//button[normalize-space()='Sign In']") 
	protected
	WebElement signinagain;
	
	
	
	
	
	public Properties getpropertyObject() throws IOException
	{
		
	FileReader reader=new FileReader("D:\\ecilipsestaples\\Ecilipse\\ui-automation-framework\\src\\main\\java\\functional\\login\\data\\Login.properties");  
	      
	    Properties p=new Properties();  
	    p.load(reader);  
	    
	    return p;
	    
	   }




	public  String getemail() throws IOException
	{
		return getpropertyObject().getProperty("Email");
	}
	public  String getpassword() throws IOException
	{
		return getpropertyObject().getProperty("Password");
	}
	

		}


