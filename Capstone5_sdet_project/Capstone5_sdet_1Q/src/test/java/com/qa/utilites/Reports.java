package com.qa.utilites;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
 
public class Reports extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReport;
	public ExtentReports xReport;
	public ExtentTest xTest;
	public void onStart(ITestContext testContext) {
		String dateStamp =  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());		
	    String repName = "WordPress-Report-"+ dateStamp +".html";
		htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+"/reports/" + repName);
		htmlReport.config().setDocumentTitle("WordPress Report");
		htmlReport.config().setReportName("SDETPractice-WordPressReport");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setAutoCreateRelativePathMedia(true);
 
		xReport = new ExtentReports();
		xReport.attachReporter(htmlReport);
		xReport.setSystemInfo("QA Name", "Jahnavi");
		xReport.setSystemInfo("OS", "Windows11");
		xReport.setSystemInfo("hostname", "localhost");
		xReport.setSystemInfo("Module", "Admin");
		xReport.setSystemInfo("Sub Module", "Customers");
		xReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		xReport.setSystemInfo("User Name", System.getProperty("user.name"));
		xReport.setSystemInfo("Environemnt", "QA");
//		String Author = testContext.getCurrentXmlTest().getParameter("author");
//		xTest.assignAuthor(Author);
	}
	public void onFinish(ITestContext testContext) {
		xReport.flush();		
	}
	public void onTestSuccess(ITestResult tr) {
		xTest = xReport.createTest(tr.getName());
		xTest.log(Status.PASS, "Test is passed");
		xTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		String ssPath = System.getProperty("user.dir")+"./screenshots/" + tr.getName() +".png";
		File file = new File(ssPath);
		if(file.exists()) {		
			try {
				xTest.pass("Screenshot of the test passed is : " + xTest.addScreenCaptureFromPath(ssPath));
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
	public void onTestFailure(ITestResult tr) {
		xTest = xReport.createTest(tr.getName());
		xTest.log(Status.FAIL, "Test is failed");
		xTest.log(Status.FAIL, tr.getThrowable());
		xTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		// read the path of screenshot with the name of the test that is failed.
		String ssPath = System.getProperty("user.dir")+"./screenshots/" + tr.getName() +".png";
		File file = new File(ssPath);
		if(file.exists()) {
			try {
				xTest.fail("Screenshot of the test failed is : " + xTest.addScreenCaptureFromPath(ssPath));
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	} 
	public void onTestSkipped(ITestResult tr) {
		xTest = xReport.createTest(tr.getName());
		xTest.log(Status.SKIP, "Test is skipped");
		xTest.log(Status.SKIP, tr.getThrowable());
		xTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
	}
}