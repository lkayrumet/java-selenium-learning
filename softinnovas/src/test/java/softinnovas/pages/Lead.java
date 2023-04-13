package softinnovas.pages;

import softinnovas.library.Browser;

public class Lead extends BasePage
{
	
	public Lead(Browser br) 
	{
		super(br);
		// TODO Auto-generated constructor stub
	}
	
	public static String getLeadTabByXPath()
	{
		return "//span[text()='Leads']/parent::a[@href='/lightning/o/Lead/home']";
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
	
	public static String getLeadStatusComBoxInputByXPath()
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

	public void clickLeadsTab()
	{
		br.executeJScToClick(getLeadTabByXPath());
	}
	
	public void clickNewLeadButton()
	{

		br.clickByXP(getNewButtonByXPath());
	}
	
	public void setFirstName(String fName)
	{
		br.setTextByXPath(getFirstNameInputeByXPath(), fName);
	}
	
	public void setLastName(String lName)
	{
		br.setTextByXPath(getLastNameInputByXPath(), lName);
	}
	
	public void setCompany(String cName)
	{
		br.setTextByXPath(getCompanyInputByXPath(), cName);
	}
	
	public void clickComboboxLeadStatus()
	{

		br.clickByXP(getLeadStatusComBoxInputByXPath());
	}
	
	public void clickLeadStatusOption(String option)
	{

		br.clickByXP(getOptionComBoxByXPath(option));
	}
	
	public void clickSaveButton()
	{

		br.clickByXP(getSaveButtonInputByXPath());
	}	
}
