package softinnovas.library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporter 
{
	String 	resultFilePath;
	ExtentReports report;
	ExtentTest test;
	
	public Reporter(String filePath)
	{
		this.resultFilePath = filePath;
		report = new ExtentReports(this.resultFilePath);
	}
	
	public void info(String msg)
	{
		test.log(LogStatus.INFO, msg);
	}
	
	public void pass(String msg)
	{
		test.log(LogStatus.PASS, msg);
	}
	
	public void fail(String msg)
	{
		test.log(LogStatus.FAIL, msg);
	}
	
	public void startTest(String testName)
	{
		test = report.startTest(testName);
	}
	
	public void endTest()
	{
		report.endTest(test);
	}
	
	public void flush()
	{
		report.flush();
	}
}
