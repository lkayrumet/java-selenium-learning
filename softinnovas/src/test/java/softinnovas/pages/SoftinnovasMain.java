package softinnovas.pages;

public class SoftinnovasMain 
{
	public static String getSignInXPath()
	{
		return "//span[text()='Sign in']";
	}
	
	public static String getEmailInputXPath()
	{
		return "//div[@class='mb-10 email-input-wrapper']//input[@type='email']";
	}
	
	public static String getPasswordInputXPath()
	{
		return "//div[@class='mb-20 pass-input-wrapper']//input[@type='password']";
	}
	
	public static String getLoginButtonId()
	{
		return "submitLogin";
	}
}