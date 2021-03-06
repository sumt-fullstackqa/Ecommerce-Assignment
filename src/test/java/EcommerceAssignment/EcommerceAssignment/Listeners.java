package EcommerceAssignment.EcommerceAssignment;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testbase.Testbase;
import utility.ExtentReporterNG;


public class Listeners extends Testbase implements ITestListener{
	
	ExtentTest test;
	
	ExtentReports extent =ExtentReporterNG.getReportObject();
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		writeLogs(result.getMethod().getMethodName() + " Started");
		writeLogs(result.getMethod().getDescription());
		
		test = extent.createTest(result.getMethod().getMethodName());
		
		extentTest.set(test);
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		extent.flush();
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		writeErrorLogs(result.getThrowable());
		
		extentTest.get().fail(result.getThrowable());
		
		// TODO Auto-generated method stub
		// here we can write code to capture screenshot 
		
		WebDriver driver=null;
		
		String testMethodName =result.getMethod().getMethodName();
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotpath(testMethodName,driver), result.getMethod().getMethodName());
		
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		writeLogs("Skipped because of - "+ result.getThrowable());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		writeLogs(result.getMethod().getMethodName() + " Passed");
		
		extentTest.get().log(Status.PASS, "Test Passed");
	}

}
