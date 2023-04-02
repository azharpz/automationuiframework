package Base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class SuiteListener implements ITestListener{

	private TakesScreenshot driver;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String fileName=System.getProperty("user.dir")+ File.separator + "screenshots" + File.separator + result.getMethod().getMethodName();
		if(ITestResult.FAILURE==result.getStatus()){
		//TakesScreenshot scrShot =((TakesScreenshot)driver);
		//File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	//	File DestFile=new File(fileName);
		//try {
			//FileUtils.copyFile(SrcFile, DestFile);
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	    try {
			TakesScreenshot screenshot=(TakesScreenshot)BaseTest.driver;
			File src=screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(fileName));
			System.out.println("Successfully captured a screenshot");


		} catch (IOException e) {
			System.out.println("Exception while taking screenshot "+e.getMessage());
			e.printStackTrace();
		}
		}
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		String fileName=System.getProperty("user.dir")+ File.separator + "screenshots" + File.separator + result.getMethod().getMethodName();
		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    try {
			FileUtils.copyFile(SrcFile, new File(fileName+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

}
