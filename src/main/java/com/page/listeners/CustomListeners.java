package com.page.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.page.Base.Pager;
import com.page.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;
import com.page.utilities.MonitoringMail;
import com.page.utilities.TestConfig;
import com.page.utilities.Utilities;

public class CustomListeners extends Pager implements ITestListener ,ISuiteListener    {

	public String messagebody;
	@Override
	
	public void onTestStart(ITestResult result) {
		test=reo.startTest(result.getName().toUpperCase());
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(LogStatus.PASS,result.getName().toUpperCase()+" pass");
		
		reo.endTest(test);
		
		reo.flush();
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		try {
			Utilities.Capturescreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL,result.getName().toUpperCase()+"Failed Exception:"+ result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.ScreenshotName));
		Reporter.log("Capturing Scrrenshot");
		Reporter.log("<a target=\"blank\"href="+Utilities.ScreenshotName+">screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a  target=\"blank\"href="+Utilities.ScreenshotName+"><img src="+Utilities.ScreenshotName+" height=200 width=200></img> </a>");
	    reo.endTest(test);
		reo.flush();
		
		
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		test.log(LogStatus.SKIP, result.getName().toUpperCase()+ "Skipped the test Runmode is no");
		 reo.endTest(test);
		 reo.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
      //if(!TestUtil.isTestRunnable(context.getName(), excel))
		//{
		//	throw new SkipException("Skipping the test :"+context.getName().toUpperCase()+ " as the RunMode is NO"); 
		//}
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ISuite suite) {
		MonitoringMail mail=new MonitoringMail();
		
		try {
			messagebody = "http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/LiveProject2-PageObjectModel/Extent_20Report/";
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.out.println(messagebody);

		
		try {
			mail.sendMail(TestConfig.server, TestConfig.from,TestConfig.to, TestConfig.subject, messagebody);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

}
