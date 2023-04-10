package Test;

import org.openqa.selenium.WebDriver;

import softinnovas.library.Browser;
import softinnovas.pages.LoginPage;

public class LoginTest extends Browser
{
	public LoginTest()
	{
		super();
	}
	
	public LoginTest(WebDriver driver)
	{
		super(driver);
	}
	
	public LoginTest(String browser)
	{
		super(browser);
	}
	
	public void login()
	{
		navigateTo("https://login.salesforce.com/");
		
		setTextByXPath(LoginPage.getEmailInputXPath(),"kayrumet-qpvt@force.com");
		
		setTextByXPath(LoginPage.gePasswordInputXPath(),"r9zhnEE44uwnzGi");
		
		click(LoginPage.getLogInButtonId());
	}
}
