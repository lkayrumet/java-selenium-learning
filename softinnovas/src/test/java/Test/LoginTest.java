package Test;

import softinnovas.library.Browser;
import softinnovas.pages.SoftinnovasMain;

public class LoginTest 
{

	public static void main(String[] args) 
	{
	  Browser browser = new Browser();
	  
	  browser.init("Chrome");
	  
	  browser.navigateTo("https://www.softinnovas.com/");
	  
	  //remove pop up
	  browser.clickByXP("//span[@class='popup-dialog-close learnworlds-icon fas fa-times']");
	  
	  
	  //open Sign in form
	  browser.clickByXP(SoftinnovasMain.getSignInXPath());
	  
	  //insert data in login form
	  browser.setTextByXPath(SoftinnovasMain.getEmailInputXPath(), "kayrumet@gmail.com");
	  browser.setTextByXPath(SoftinnovasMain.getPasswordInputXPath(), "Lu1s02011");
	  
	  //send login data
	  browser.click(SoftinnovasMain.getLoginButtonId());
	 
	}

}
