package Test;

import softinnovas.library.Browser;
import softinnovas.library.Reporter;

public class BaseTest 
{	
	public static void main(String arg[])
	{
		Browser browser = new Browser("chrome");
		
		Reporter r = new Reporter("C:\\DISCO D\\Selenium\\testResults.html");
		
		r.startTest("Testing SalesForce Login");
		
		
		try
		{
			LoginTest loginTest = new LoginTest(browser.getDriver());
			loginTest.login();
			
			
			r.pass("Test Succesfully Passed");
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			r.fail("Test Failed");
		}	
		
		r.endTest();
		
		
		//temporary click
		browser.clickByXP("//button[@title='Close this window']");
		
		
		/*
		r.startTest("Start 5 Lead adding Test");
		try 
		{
			LeadsTest leadTest = new LeadsTest(browser.getDriver());
			leadTest.newLeadTest("C:\\Users\\kayru\\eclipse-workspace\\selenium\\java-selenium-learning\\softinnovas\\testingData.xlsx");
			r.pass("Leads successfully added");
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			r.fail("Adding 5 Leads failed");
		}	
		
		r.endTest();*/
		
		r.startTest("Add Account");
		try 
		{
			AccountsTest account = new AccountsTest(browser.getDriver());
			account.newAccountTest("C:\\Users\\kayru\\eclipse-workspace\\selenium\\java-selenium-learning\\softinnovas\\testingData.xlsx");
			r.pass("Account successfully added");
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			r.fail("Adding accounts failed");
		}	
		
		r.endTest();
		
		
		r.flush();
	}
}
