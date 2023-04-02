package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentHTMLReporter {
	
static ExtentReports extent;
	
	public static  ExtentReports getReportObject() {
	
	String path=System.getProperty("user.dir")+"\\extentreports\\index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setReportName("Automation Test Results");
	reporter.config().setDocumentTitle("Automation Test Results");
	
	extent = new ExtentReports();
	extent.attachReporter(reporter);;
	extent.setSystemInfo("Azhar","SDET");
	return extent;
	
	
	
	

}}
