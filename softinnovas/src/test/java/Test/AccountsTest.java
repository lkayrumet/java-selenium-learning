package Test;

import org.openqa.selenium.WebDriver;

import softinnovas.library.Browser;
import softinnovas.library.ExcelFile;

public class AccountsTest extends Browser
{
	ExcelFile ex; 
	
	public AccountsTest()
	{
		super();
	}
	
	public AccountsTest(WebDriver driver)
	{
		super(driver);
	}
	
	public AccountsTest(String browser)
	{
		super(browser);
	}
	
	public void newAccountTest(String excelData)
	{
		/*this.ex = new ExcelFile(excelData);
		this.ex.setSheetByName("Accounts");
		
		Iterator<Row> rows = ex.getSheet().iterator();
		rows.next();
		
		while(rows.hasNext())
		{
			if(waitByXPath(AccountsTabSelectors.getAccountsTabByXPath()))
			{
				WebElement element = driver.findElement(By.xpath(AccountsTabSelectors.getAccountsTabByXPath()));
			    JavascriptExecutor executor = (JavascriptExecutor)driver;
			    executor.executeScript("arguments[0].click();", element);
			}		    
			Row row = rows.next();
			int rNum = row.getRowNum();
			

			clickByXP(AccountsTabSelectors.getNewButtonByXPath());

			setTextByXPath(AccountsTabSelectors.getAccountNameByXPath(), ex.getCellData(rNum, "Write"));
		
			clickByXP(AccountsTabSelectors.getComboboxAccountNameByPath(ex.getCellData(rNum, "Account Name")));

			clickByXP(AccountsTabSelectors.getSaveButtonByXPath());
			
		}
		
		
		WebElement element = driver.findElement(By.xpath(AccountsTabSelectors.getAccountsTabByXPath()));
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", element);
		   
	    System.out.println("END ExECUTION");*/
	}
}
