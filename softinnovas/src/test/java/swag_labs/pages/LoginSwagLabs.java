package swag_labs.pages;

import softinnovas.library.Browser;
import softinnovas.pages.BasePage;

public class LoginSwagLabs extends BasePage
{
	public LoginSwagLabs(Browser br)
	{
		super(br);
	}
	
	public void setUser(String user)
	{	
		br.setText("user-name", user);
	}
	
	public void setPassword(String password)
	{
		br.setText("password", password);
	}
	
	public void clickLoginButton()
	{
		br.clickByID("login-button");
	}
	
	public String getHeaderByXPath()
	{
		return br.getTextByXPath("//span[@class='title']");
	}
	
	public String getDataMessageError()
	{
		return br.getTextByXPath("//h3[@data-test='error']");
	}
	
	public void ClickMenuButton()
	{
		br.clickByID("react-burger-menu-btn");
	}
	
	public void ClickLogoutButton()
	{
		br.clickByID("logout_sidebar_link");
	}
	
	public String getInputValuetByID(String id)
	{
		return br.getTextByID(id);
	}
	
	public void LoginRightCredentials()
	{
		setUser("standard_user");
		setPassword("secret_sauce"); 
		clickLoginButton();
	}
}
