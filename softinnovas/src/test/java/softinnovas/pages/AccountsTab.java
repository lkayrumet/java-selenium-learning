package softinnovas.pages;

public class AccountsTab
{
	public static String getAccountsTabByXPath()
	{
		return "//span[text()='Accounts']/parent::a[@href='/lightning/o/Account/home']";
	}
	
	public static String getNewButtonByXPath()
	{
		return "//div[@title='New']";
	}
	
	public static String getAccountNameByXPath()
	{
		return "(//input[@role='combobox'])[1]";
	}
	
	public static String getSaveButtonByXPath()
	{
		return "//button[@title='Save']";
	}
	
	public static String getComboboxAccountNameByPath(String name)
	{
		return "//div[@title="+name+"]";
	}
	
}
