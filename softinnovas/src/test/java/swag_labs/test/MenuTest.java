package swag_labs.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import softinnovas.library.Browser;
import swag_labs.pages.LoginSwagLabs;
import swag_labs.pages.MenuPage;

public class MenuTest 
{	
	Browser browser = new Browser("chrome");
	LoginSwagLabs login = new LoginSwagLabs(browser);
	MenuPage menu = new MenuPage(browser);
	
	@BeforeClass
	public void login()
	{
		browser.navigateTo("https://www.saucedemo.com/");
		login.setUser("standard_user");
		login.setPassword("secret_sauce"); 
		login.clickLoginButton();
		Assert.assertEquals(login.getHeaderByXPath(), "Products");
	}
	
	@Test
	public void MenuAvailable()
	{
		menu.checkMenuIconIsVisibleAndClicable();
	}
	
	@Test
	public void MenuOptionsAvailable()
	{
		menu.clickMenuIcon();
		Assert.assertEquals(menu.CountMenuOptions(), 4);
	}
	
	@Test
	public void CheckMenuOptionsText()
	{
		menu.clickMenuIcon();
		System.out.println(menu.getTextMenuAllItems());
		Assert.assertEquals(menu.getTextMenuAllItems(), "All Items");
		Assert.assertEquals(menu.getTextMenuAbout(), "About");
		Assert.assertEquals(menu.getTextMenuLogout(), "Logout");
		Assert.assertEquals(menu.getTextMenuResetApp(), "Reset App State");
	}
	
	@Test
	public void logout()
	{
		menu.clickMenuIcon();
		menu.clickLogoutButton();
		login.clickLoginButton();
	}
	
	@Test
	public void About()
	{
		menu.clickMenuIcon();
		menu.clickAboutButton();	
		Assert.assertEquals(menu.AboutPage(), "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing");
	}
	
	@Test
	public void CloseMenu() throws InterruptedException
	{
		menu.clickMenuIcon();
		menu.clickCloseMenu();
		//Thread.sleep(500);
		Assert.assertTrue(menu.CheckMenuIsVisible());
	}
	
	
	@AfterClass
	public void EndClass()
	{
		browser.close();
	}
}
