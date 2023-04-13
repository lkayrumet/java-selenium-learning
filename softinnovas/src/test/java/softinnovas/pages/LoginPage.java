package softinnovas.pages;

import softinnovas.library.Browser;

public class LoginPage extends BasePage
{
	public LoginPage(Browser br) 
	{
		super(br);
		// TODO Auto-generated constructor stub
	}
	private String getEmailInputXPath()
	{
		return "//input[@type='email']";
	}
	
	private String getPasswordInputXPath()
	{
		return "//input[@type='password']";
	}
	
	private String getLogInButtonId()
	{
		return "Login";
	}
	
	public void setUserEmail(String user)
	{
		br.setTextByXPath(getEmailInputXPath(), user);
	}
	
	public void setPassword(String user)
	{

		br.setTextByXPath(getPasswordInputXPath(), user);
	}
	
	public void clickLoginButton()
	{

		br.clickByID(getLogInButtonId());
	}
	
}
