package softinnovas.pages;

public class LeadSelectors 
{
	
	public static String getLeadTabByXPath()
	{
		return "//span[text()='Leads']/parent::a[contains(@href,'/lightning/o/Lead/home')]";
	}
	public static String getNewButtonByXPath()
	{
		return "//div[@title='New']";
	}
	
	public static String getFirstNameInputeByXPath()
	{
		return "//input[@name='firstName']";
	}
	
	public static String getLastNameInputByXPath()
	{
		return "//input[@name='lastName']";
	}
	
	public static String getCompanyInputByXPath()
	{
		return "//input[@name='Company']";
	}
	
	public static String getLeadStatusComBoxInputById()
	{
		return "//button[@data-value='New']";
	} 
	
	public static String getSaveButtonInputByXPath()
	{
		return "//button[@class='slds-button slds-button_brand']";
	}
	
	public static String getCancelButtonByXPath()
	{
		return "//button[@class='slds-button slds-button_neutral' and @name='CancelEdit']";
	}
	
	public static String getSaveAndNewButtonByXPath()
	{
		return "//button[@class='slds-button slds-button_neutral' and @name='SaveAndNew']";
	}
	
	public static String getOptionComBoxByXPath(String op)
	{
		return "//span[@title='"+op+"']";
	}
}
