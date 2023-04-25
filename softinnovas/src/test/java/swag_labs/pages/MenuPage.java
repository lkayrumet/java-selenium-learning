package swag_labs.pages;

import softinnovas.library.Browser;
import softinnovas.library.Reporter;
import softinnovas.pages.BasePage;

public class MenuPage extends BasePage
{
	public MenuPage(Browser br, Reporter r)
	{
		super(br, r);
	}
	
	public String getMenuButtonID()
	{
		return "react-burger-menu-btn";
	}
	
	public void checkMenuIconIsVisibleAndClicable()
	{
		br.waitVisibleByID(getMenuButtonID());
		br.waitClickableByID(getMenuButtonID());
	}
	
	public Boolean CheckMenuIsVisible()
	{
		return br.isDisplayedByXPath("//div[@class='bm-menu-wrap']");
	}
	
	public int CountMenuOptions()
	{
		return br.countElementsByXPath("//a[@class='bm-item menu-item']");
	}
	
	public void clickMenuIcon()
	{
		br.clickByID(getMenuButtonID());
	}
	
	public String getTextMenuAllItems()
	{
		return br.getTextByID("inventory_sidebar_link");
	}
	
	public String getTextMenuAbout()
	{
		return br.getTextByID("about_sidebar_link");
	}
	
	public String getTextMenuLogout()
	{
		return br.getTextByID("logout_sidebar_link");
	}
	
	public String getTextMenuResetApp()
	{
		return br.getTextByID("reset_sidebar_link");
	}
	
	public void clickLogoutButton()
	{
		br.clickByID("logout_sidebar_link");
	}
	
	public void clickAboutButton()
	{
		br.clickByID("about_sidebar_link");
	}
	
	public String AboutPage()
	{
		return br.getTextByXPath("//title");
	}
	
	public void clickCloseMenu()
	{
		br.clickByID("react-burger-cross-btn");
	}
}
