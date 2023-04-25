package swag_labs.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import softinnovas.library.Browser;
import softinnovas.library.ExcelFile;
import softinnovas.library.Reporter;
import swag_labs.pages.LoginSwagLabs;

public class LoginSwagTest 
{
	Browser browser = new Browser("chrome");
	Reporter report; 
	LoginSwagLabs login = new LoginSwagLabs(browser, report);
	
	
	@BeforeClass
	public void preTest()
	{
		String date =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		report= new Reporter("C:\\DISCO D\\Selenium\\Login_Swag_Test_Result_"+date+".html");
	}
	
	@Test
	public void LoginRightCredentials()
	{
		report.startTest("Login test right credentials initialized");
		browser.navigateTo("https://www.saucedemo.com/");
		try
		{
			login.setUser("standard_user");
			login.setPassword("secret_sauce"); 
			login.clickLoginButton();
			
			
			String foto = browser.takeScreenShot();
			report.addScreenShot(foto);
			
			login.verify(login.getHeaderByXPath(), "Products");
					
			login.ClickMenuButton();
			login.ClickLogoutButton();
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void LoginBlockedUser()
	{
		report.startTest("Login test user blocked initialized");
		browser.navigateTo("https://www.saucedemo.com/");
		
		try 
		{
			login.setUser("locked_out_user");
			login.setPassword("secret_sauce"); 
			login.clickLoginButton();
			login.verify(login.getDataMessageError(),"Epic sadface: Sorry, this user has been locked out.");
		}
		catch (Exception e) {
			// TODO: handle exception
			report.fail("Test Failed.");
		}
		
	}
	
	@Test
	public void LoginEmptyUser()
	{
		report.startTest("Login test user empty initialized");
		browser.navigateTo("https://www.saucedemo.com/");
		try 
		{
			login.setUser("");
			login.setPassword("secret_sauce"); 
			login.clickLoginButton();
			login.verify(login.getDataMessageError(),"Epic sadface: Username is required");
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
		
		
	}
	
	@Test
	public void LoginEmptyPassword()
	{
		report.startTest("Login test password empty initialized");
		browser.navigateTo("https://www.saucedemo.com/");
		try
		{
			login.setUser("standard_user");
			login.setPassword(""); 
			login.clickLoginButton();
			login.verify(login.getDataMessageError(),"Epic sadface: Password is required");
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
		
	}
	
	@Test
	public void LoginEmptyUserAndEmptyPassword()
	{
		report.startTest("Login test user and password empty initialized");
		browser.navigateTo("https://www.saucedemo.com/");
		try
		{
			login.setUser("");
			login.setPassword(""); 
			login.clickLoginButton();
			login.verify(login.getDataMessageError(),"Epic sadface: Username is required");
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void LoginWrongUser()
	{
		report.startTest("Login test wrong user initialized");
		browser.navigateTo("https://www.saucedemo.com/");
		try
		{
			login.setUser("Luis");
			login.setPassword("secret_sauce"); 
			login.clickLoginButton();
			login.verify(login.getDataMessageError(),"Epic sadface: Username and password do not match any user in this service");
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void LoginWrongPassword()
	{
		report.startTest("Login test wrong password initialized");
		browser.navigateTo("https://www.saucedemo.com/");
		try
		{
			login.setUser("standard_user");
			login.setPassword("Luis"); 
			login.clickLoginButton();
			login.verify(login.getDataMessageError(),"Epic sadface: Username and password do not match any user in this service");
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void LoginWrongUserFormat()
	{
		report.startTest("Login test wrong user format initialized");
		browser.navigateTo("https://www.saucedemo.com/");
		try 
		{
			login.setUser("LuiS!@#");
			login.setPassword("aweqwee"); 
			login.clickLoginButton();
			login.verify(login.getDataMessageError(),"Epic sadface: Username and password do not match any user in this service");
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}

	@AfterClass
	public void endTestClass()
	{
		report.flush();
		browser.close();
	}
	
	@Test
	public void LoginAllTestsInOne()
	{
		Browser browser = new Browser("chrome");
		browser.navigateTo("https://www.saucedemo.com/");
		
		LoginSwagLabs login = new LoginSwagLabs(browser, report);
		
		
		ExcelFile ex; 
		
		Reporter r = new Reporter("C:\\DISCO D\\Selenium\\Login_Swag_Test_Results.html");
		
		
		try 
		{
			ex = new ExcelFile("C:\\Users\\kayru\\eclipse-workspace\\selenium\\java-selenium-learning\\softinnovas\\Data_Test_Swag_Web_Site.xlsx");
			ex.setSheetByName("login_cases");
			Iterator<Row> rows = ex.getSheet().iterator();
			rows.next();
			
			while(rows.hasNext())
			{
				Row row = rows.next();
				int rNum = row.getRowNum();
				
				r.startTest("Testing Swag Bag Login");
				
				login.setUser(ex.getCellData(rNum, "user"));
				login.setPassword(ex.getCellData(rNum, "password")); 
				System.out.println(login.getInputValuetByID("user-name")+"---"+login.getInputValuetByID("password")+"///");
				login.clickLoginButton();
				
				String value = ex.getCellData(rNum, "test_type");
				float num = Float.parseFloat(value);
				int test_type = (int)num;
				
				switch (test_type) 
				{
				case 1:
					try 
					{
						r.info("Data for successfully login entered");
						if(login.getHeaderByXPath().equals("Products"))
						{
							r.pass("Test Successfully completed");
						}
						else
						{
							r.fail("login test failed");
						}
						login.ClickMenuButton();
						login.ClickLogoutButton();
					}
					catch (Exception e) 
					{
						// TODO: handle exception
						r.fail("login test failed");
					}
					break;
					
				case 2:
					try
					{
						r.info("Empty user for failed login");
						if(login.getDataMessageError().equals("Epic sadface: Username is required"))
						{
							r.pass("Test Successfully completed");
						}
						else
						{
							r.fail("login test failed");
						}
					}
					catch (Exception e) 
					{
						// TODO: handle exception
						r.fail("login test failed");
					}
					break;
				case 3:
					try
					{
						r.info("Empty password for failed login");
						if(login.getDataMessageError().equals( "Epic sadface: Password is required"))
						{
							r.pass("Test Successfully completed");
						}
						else
						{
							r.fail("login test failed");
						}
					}
					catch (Exception e) 
					{
						// TODO: handle exception
						r.fail("login test failed");
					}
					break;
				case 4:
					try
					{
						r.info("Entered blocked user for failed login");
						if(login.getDataMessageError().equals("Epic sadface: Sorry, this user has been locked out."))
						{
							r.pass("Test Successfully completed");
						}
						else
						{
							r.fail("login test failed");
						}
					}
					catch (Exception e) 
					{
						// TODO: handle exception
						r.fail("login test failed");
					}
					break;
				case 5:
					try
					{
						r.info("Empty user and password for failed login");
						if(login.getDataMessageError().equals("Epic sadface: Username is required"))
						{
							r.pass("Test Successfully completed");
						}
						else
						{
							r.fail("login test failed");
						}
					}
					catch (Exception e) 
					{
						// TODO: handle exception
						r.fail("login test failed");
					}
					break;
				case 6:
					try
					{
						r.info("Entered wrong user for failed login");
						if(login.getDataMessageError().equals("Epic sadface: Username and password do not match any user in this service"))
						{
							r.pass("Test Successfully completed");
						}
						else
						{
							r.fail("login test failed");
						}
					}
					catch (Exception e) 
					{
						// TODO: handle exception
						r.fail("login test failed");
					}
					break;
				case 7:
					try
					{
						r.info("Entered wrong password for failed login");
						if(login.getDataMessageError().equals("Epic sadface: Username and password do not match any user in this service"))
						{
							r.pass("Test Successfully completed");
						}
						else
						{
							r.fail("login test failed");
						}
					}
					catch (Exception e) 
					{
						// TODO: handle exception
						r.fail("login test failed");
					}
					break;
				case 8:
					try
					{
						r.info("Entered user with no alphanumeric characters for failed login");
						if(login.getDataMessageError().equals("Epic sadface: Username and password do not match any user in this service"))
						{
							r.pass("Test Successfully completed");
						}
						else
						{
							r.fail("login test failed");
						}
					}
					catch (Exception e) 
					{
						// TODO: handle exception
						r.fail("login test failed");
					}
					break;
				default:
					break;
				}
				
			}			   
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.flush();
		browser.close();
	}
}
