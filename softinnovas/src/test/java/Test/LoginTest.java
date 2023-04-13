package Test;

import softinnovas.library.Browser;
import softinnovas.pages.LoginPage;

public class LoginTest
{
	public static void main(String arg[])
	{
		Browser browser = new Browser("chrome");
		browser.navigateTo("https://login.salesforce.com/");
		
		LoginPage login = new LoginPage(browser);
		login.setUserEmail("kayrumet-qpvt@force.com");
		login.setPassword("r9zhnEE44uwnzGi");
		login.clickLoginButton();
	}
}
