package org.blazedemo.tests.listeners;

import java.awt.AWTException;
import java.io.IOException;

import org.blazedemo.tests.base.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BlazeListener implements ITestListener{

	ExtentReports extent;
	ExtentTest test;
	
	  public void onStart(ITestContext context) {
		  ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Report\\BlazeDemo.html");
		  extent = new ExtentReports();
		  extent.attachReporter(spark);
		  }
	
	  public void onTestStart(ITestResult result) {
		    System.out.println("On Test Start");
		    test = extent.createTest(result.getMethod().getMethodName());
		  }
	  
	  public void onTestSuccess(ITestResult result) {
		  System.out.println("On Test Sucess");
		  test.log(Status.PASS, "Test Passed" + result.getName());
		  }
	  
	  public void onTestFailure(ITestResult result) {
		  System.out.println("On Test Failure");
		  
		  test.log(Status.FAIL,"Test Failed");
		  test.log(Status.FAIL, result.getThrowable());
		  
		  try {
			String ScreenshotPath = BaseClass.takeScreenshot();
			test.addScreenCaptureFromPath(ScreenshotPath);
		} catch (AWTException e) {
			test.log(Status.WARNING, "Screenshot Capture Failed" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  }
	  
	  public void onTestSkipped(ITestResult result) {
		  System.out.println("On Test Skipped");
		  test.log(Status.SKIP, "Test Skipped" + result.getName());
		  }
	  
	  public void onFinish(ITestContext context) {
		  extent.flush();
		  }
}
