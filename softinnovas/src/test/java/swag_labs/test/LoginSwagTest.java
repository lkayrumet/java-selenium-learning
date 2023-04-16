package swag_labs.test;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.testng.Assert;
import org.testng.annotations.Test;

import softinnovas.library.Browser;
import softinnovas.library.ExcelFile;
import softinnovas.library.Reporter;
import swag_labs.pages.LoginSwagLabs;

public class LoginSwagTest 
{
	Browser browser = new Browser("chrome");
	LoginSwagLabs login = new LoginSwagLabs(browser);
	
	
	@Test(groups= {"main"})
	public void LoginRightCredentials()
	{
		
		browser.navigateTo("https://www.saucedemo.com/");
		
		login.setUser("standard_user");
		login.setPassword("secret_sauce"); 
		login.clickLoginButton();
		Assert.assertEquals(login.getHeaderByXPath(), "Products");
		login.ClickMenuButton();
		login.ClickLogoutButton();
	}
	
	@Test
	public void LoginBlockedUser()
	{
		browser.navigateTo("https://www.saucedemo.com/");
		
		login.setUser("locked_out_user");
		login.setPassword("secret_sauce"); 
		login.clickLoginButton();
		Assert.assertEquals(login.getDataMessageError(),"Epic sadface: Sorry, this user has been locked out.");
	}
	
	@Test
	public void LoginEmptyUser()
	{
		browser.navigateTo("https://www.saucedemo.com/");
		
		login.setUser("");
		login.setPassword("secret_sauce"); 
		login.clickLoginButton();
		Assert.assertEquals(login.getDataMessageError(),"Epic sadface: Username is required");
	}
	
	@Test
	public void LoginEmptyPassword()
	{
		browser.navigateTo("https://www.saucedemo.com/");
		
		login.setUser("standard_user");
		login.setPassword(""); 
		login.clickLoginButton();
		Assert.assertEquals(login.getDataMessageError(),"Epic sadface: Password is required");
	}
	
	@Test
	public void LoginEmptyUserAndEmptyPassword()
	{
		browser.navigateTo("https://www.saucedemo.com/");
		
		login.setUser("");
		login.setPassword(""); 
		login.clickLoginButton();
		Assert.assertEquals(login.getDataMessageError(),"Epic sadface: Username is required");
	}
	
	@Test
	public void LoginWrongUser()
	{
		browser.navigateTo("https://www.saucedemo.com/");
		
		login.setUser("Luis");
		login.setPassword("secret_sauce"); 
		login.clickLoginButton();
		Assert.assertEquals(login.getDataMessageError(),"Epic sadface: Username and password do not match any user in this service");
	}
	
	@Test
	public void LoginWrongPassword()
	{
		browser.navigateTo("https://www.saucedemo.com/");
		
		login.setUser("standard_user");
		login.setPassword("Luis"); 
		login.clickLoginButton();
		Assert.assertEquals(login.getDataMessageError(),"Epic sadface: Username and password do not match any user in this service");
	}
	
	@Test
	public void LoginWrongUserFormat()
	{
		browser.navigateTo("https://www.saucedemo.com/");
		
		login.setUser("LuiS!@#");
		login.setPassword("aweqwee"); 
		login.clickLoginButton();
		Assert.assertEquals(login.getDataMessageError(),"Epic sadface: Username and password do not match any user in this service");
	}

	
	@Test
	public void LoginAllTestsInOne()
	{
		Browser browser = new Browser("chrome");
		browser.navigateTo("https://www.saucedemo.com/");
		
		LoginSwagLabs login = new LoginSwagLabs(browser);
		
		
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
