package Base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import functional.dashboard.pages.Dashboard;
import util.Constants;
import util.ExtentHTMLReporter;



public class BaseTest {
	
	
	public static WebDriver driver;
	public ExtentHTMLReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	static Logger log = Logger.getLogger(BaseTest.class.getName());

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
	
	
     @BeforeMethod
     @Parameters(value= {"browserName"})
     
	public void beforeMethodMethod(@Optional String browserName, Method testMethod) {
    	 ExtentTest Test = extent.createTest("Dashboard");

    		/**
    		 * Create new LandingPage object with the given driver.<br>
    		 * <br>
    		 * Driver is passed through to the backing object class.
    		 * 
    		 * @param driver active driver to use for this page
    		 */

		logger=extent.createTest(testMethod.getName());
		setupDriver(browserName);
		driver.manage().window().maximize();
		log.info("window maximise");
		Test.info("window maximise");
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	
	
	
	 @AfterMethod
	public void afterMethodMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			String methodName=result.getMethod().getMethodName();
			String logText="Test Case:" +methodName + "Passed";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			logger.log(Status.PASS, m);
			
		}else if(result.getStatus()==ITestResult.FAILURE) {
			String methodName=result.getMethod().getMethodName();
			String logText="Test Case:" +methodName + "Failed";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.RED);
			logger.log(Status.FAIL, m);
			
			String fileName=System.getProperty("user.dir")+ File.separator + "screenshots" + File.separator + result.getMethod().getMethodName();
			File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		    try {
				FileUtils.copyFile(SrcFile, new File(fileName+".png"));
			} catch (IOException e) {
				
				e.printStackTrace();
			
		}	
		
		}	
		driver.quit();
		
	}
	
	
	
	
	@AfterTest
	public void afterTestMethod() {
		extent.flush();
			
	}
	
	public void setupDriver(@Optional String browserName) {

		System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");

		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ File.separator + "drivers" + File.separator +"chromedriver.exe");
		driver=new ChromeDriver();
		//ChromeOptions options = new ChromeOptions();

		//options.addArguments("--remote-allow-origins=*");

		//ChromeDriver driver = new ChromeDriver(options);


		
	}


	public void runScript() throws IOException {
		// TODO Auto-generated method stub
		
	}
	protected void executeTest() {
		// TODO Auto-generated method stub
		
	}
}
