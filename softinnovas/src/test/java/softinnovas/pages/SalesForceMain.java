package softinnovas.pages;

public class SalesForceMain 
{
	public static String getPreFirstShadowDom()
	{
		return "//div[@class='globalnav-wrapper-c360']//hgf-c360nav";
	}
	
	public static String getPreSecondShadowDom()
	{
		return "li[class='utility-icons-items login'] hgf-c360login";
	}
	
	public static String getLoginButton()
	{
		return "hgf-popover div div a";
	}
}