package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.Base;
import utilities.ExtentReport;

public class Listeners1 extends Base implements  ITestListener  {

	
	WebDriver driver;
	ExtentTest test;
	ExtentReports extentReport=ExtentReport.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test= extentReport.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}


	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
		try {	
			//System.out.println("************"+result.getThrowable()+"************");
			extentTest.get().pass(result.getThrowable());
			
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());			
			takeScreenshot(driver,result.getMethod().getMethodName());
		
			
	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentReport.flush();
		
	} 


}
