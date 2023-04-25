package swag_labs.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import softinnovas.library.Browser;
import softinnovas.library.Reporter;
import swag_labs.pages.LoginSwagLabs;
import swag_labs.pages.MenuPage;

public class MenuTest 
{	
	Browser browser = new Browser("chrome");
	Reporter report; 
	LoginSwagLabs login = new LoginSwagLabs(browser, report);
	MenuPage menu = new MenuPage(browser, report);
	
	
	@BeforeClass
	public void login()
	{
		String date =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		report= new Reporter("C:\\DISCO D\\Selenium\\Menu_Swag_Test_Result_"+date+".html");
		
		browser.navigateTo("https://www.saucedemo.com/");
		
		login.setUser("standard_user");
		login.setPassword("secret_sauce"); 
		login.clickLoginButton(); 
	}
	
	@Test
	public void MenuAvailable()
	{
		report.startTest("Menu available test initialized");
		try
		{	
			menu.checkMenuIconIsVisibleAndClicable();
			report.pass("Test completed successfully");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void MenuOptionsAvailable()
	{
		report.startTest("Menu count options available test initialized");
		try
		{
			menu.clickMenuIcon();
			menu.verify(menu.CountMenuOptions(), 4);
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
		
	}
	
	@Test
	public void CheckMenuOptionsText()
	{
		report.startTest("Menu check options text test initialized");
		try
		{
			menu.clickMenuIcon();
			Assert.assertEquals(menu.getTextMenuAllItems(), "All Items");
			Assert.assertEquals(menu.getTextMenuAbout(), "About");
			Assert.assertEquals(menu.getTextMenuLogout(), "Logout");
			Assert.assertEquals(menu.getTextMenuResetApp(), "Reset App State");
			report.pass("Test completed successfully");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void logout()
	{
		report.startTest("Menu logout option test initialized");
		try
		{
			menu.clickMenuIcon();
			menu.clickLogoutButton();
			login.clickLoginButton();
			report.pass("Test completed successfully");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void About()
	{
		report.startTest("Menu about option test initialized");
		try
		{
			menu.clickMenuIcon();
			menu.clickAboutButton();	
			menu.verify(menu.AboutPage(), "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void CloseMenu() throws InterruptedException
	{
		report.startTest("Menu close menu test initialized");
		try
		{
			menu.clickMenuIcon();
			menu.clickCloseMenu();
			Assert.assertTrue(menu.CheckMenuIsVisible());
			report.pass("Test completed successfully");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	
	@AfterClass
	public void EndClass()
	{
		report.flush();
		browser.close();
	}
}
