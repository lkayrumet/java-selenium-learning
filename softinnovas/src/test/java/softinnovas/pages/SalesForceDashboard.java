package softinnovas.pages;

public class SalesForceDashboard 
{
	public static String getUserNameXPath()
	{
		return "//h1//a[@class='profile-link-label']";
	}
	
	public static String getViewProfileButtonXPath()
	{
		return "//div[@class='profileTrigger branding-user-profile bgimg slds-avatar slds-avatar_profile-image-small circular forceEntityIcon']";
	}
	
	public static String getLogoutXPath()
	{
		return "//a[@class='profile-link-label logout uiOutputURL']";
	}
}
