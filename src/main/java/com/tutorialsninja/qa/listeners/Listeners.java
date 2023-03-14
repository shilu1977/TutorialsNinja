package com.tutorialsninja.qa.listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.ExtentReporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Override;
import java.util.logging.FileHandler;

public class Listeners implements ITestListener{
	
	ExtentReports extentReport;
	ExtentTest extentTest;
	
	public void onStart(ITestContext context) {
		System.out.println("Test Execution of the project started");
		
		try {
			extentReport = ExtentReporter.generateExtentReporter();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	public void onTestStart(ITestResult result) {

		String testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName + "started executing");
		
	}

	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.PASS, testName + "TestCase executed successfully");
		}

	public void onTestFailure(ITestResult result) {
		
		String testName = result.getName();
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File srcScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationScreenshotPath = new File("C:\\Users\\shilu\\eclipse-workspace\\EdurekaSelenium\\TutorialsNinja\\Screenshot" + testName + ".png"); 
		try {
			FileUtils.copyFile(srcScreenShot, destinationScreenshotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName + "------TestCase Failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName + "TesCase skipped");
		
	}

	
	public void onFinish(ITestContext context) {

		extentReport.flush();
	}
	
	

}
