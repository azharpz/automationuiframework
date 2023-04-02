package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.remote.MobileCapabilityType;
import util.ExtentHTMLReporter;

public class AndroidLaunch {
	
	
	public ExtentHTMLReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	private static AndroidDriver driver;

	@SuppressWarnings("rawtypes")
	public static AndroidDriver capabilities() throws IOException {
		// TODO Auto-generated method stub
		
		 DesiredCapabilities capability=new DesiredCapabilities();
			//AndroidDriver<AndroidElement>  driver=capabilities();




		    capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Mi A3");
		    capability.setCapability(MobileCapabilityType.PLATFORM, "Android");
		    capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		 capability.setCapability("automationName", "UiAutomator2");
		// capability.setCapability("noSign", "true");
		capability.setCapability("noReset", "true");
	   capability.setCapability("appPackage", "com.s9truck.customer");
	capability.setCapability("appActivity", "com.s9truck.customer.ui.activities.SplashActivity");


		//  capability.setCapability("appPackage", "com.hss.android.viaetruck");


		//	capability.setCapability("appActivity", "com.hss.android.viaetruck.activity.SplashScreen");
			
			
			AndroidDriver driver1=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    return driver1;
	   
	}
	
	@BeforeTest
	public void beforeTestMethod() {

		String path=System.getProperty("user.dir")+ File.separator + "reports" + File.separator +"AutomationReport.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Test Results");
		reporter.config().setDocumentTitle("Automation Test Results");
		
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);;
		extent.setSystemInfo("Azhar","SDET");
		//ExtentTest Test=extent.createTest("My Test");
		//Test.pass("ff");
		//Test.fail("ddd");
		//Test.info("fff");
		
		
		
		
		
	}
	
	//public static  String getdevice() throws IOException
	//{
	//	return getpropertyObject().getProperty("devicename");
	//}


	//public static  String getversion() throws IOException
	//{
	//	return getpropertyObject().getProperty("version");
	//}

	
	

}
