package functional.addcustomer.pages;

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
import functional.login.pageobjects.LoginPageObjects;
import util.ExtentHTMLReporter;

/**
 * Object/UI interactions for the Landing page.<br>
 * <br>
 * Holds multiple methods for the landing page header navigation, search, etc.
 */
public class Login extends LoginPageObjects {
	ExtentTest Test = extent.createTest("Login");

	/**
	 * Create new LandingPage object with the given driver.<br>
	 * <br>
	 * Driver is passed through to the backing object class.
	 * 
	 * @param driver active driver to use for this page
	 */

	static Logger log = Logger.getLogger(Login.class.getName());

	public Login(WebDriver driver) {

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
	
	

	public void enterLoginDetail() throws IOException, InterruptedException{
	}
}





