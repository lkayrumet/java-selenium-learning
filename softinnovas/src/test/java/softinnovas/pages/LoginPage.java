package softinnovas.pages;

public class LoginPage 
{
	public static String getEmailInputXPath()
	{
		return "//input[@type='email']";
	}
	
	public static String gePasswordInputXPath()
	{
		return "//input[@type='password']";
	}
	
	public static String getLogInButtonId()
	{
		return "Login";
	}
}
