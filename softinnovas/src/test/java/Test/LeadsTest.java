package Test;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import softinnovas.library.Browser;
import softinnovas.library.ExcelFile;
import softinnovas.pages.LeadSelectors;

public class LeadsTest extends Browser
{
	ExcelFile ex; 
	
	public LeadsTest()
	{
		super();
	}
	
	public LeadsTest(WebDriver driver)
	{
		super(driver);
	}
	
	public LeadsTest(String browser)
	{
		super(browser);
	}
	
	public void newLeadTest(String excelData) throws InterruptedException
	{
		
		
		this.ex = new ExcelFile(excelData);
		this.ex.setSheetByName("Leads");
		
		//Select and click tab Leads
				
		Iterator<Row> rows = ex.getSheet().iterator();
		rows.next();
		
		
		while(rows.hasNext())
		{
			if(waitByXPath(LeadSelectors.getLeadTabByXPath()))
			{
				WebElement element = driver.findElement(By.xpath(LeadSelectors.getLeadTabByXPath()));
			    JavascriptExecutor executor = (JavascriptExecutor)driver;
			    executor.executeScript("arguments[0].click();", element);
			}		    
			Row row = rows.next();
			int rNum = row.getRowNum();
			
			if(waitByXPath(LeadSelectors.getNewButtonByXPath()))
			{
				clickByXP(LeadSelectors.getNewButtonByXPath());
			}


			if(waitByXPath(LeadSelectors.getFirstNameInputeByXPath()))
			{
				setTextByXPath(LeadSelectors.getFirstNameInputeByXPath(), ex.getCellData(rNum, "FirstName"));
				setTextByXPath(LeadSelectors.getLastNameInputByXPath(), ex.getCellData(rNum, "LastName"));
				setTextByXPath(LeadSelectors.getCompanyInputByXPath(), ex.getCellData(rNum, "Company"));
				
				clickByXP(LeadSelectors.getLeadStatusComBoxInputByXPath());
			} 

			
			if(waitByXPath(LeadSelectors.getOptionComBoxByXPath(ex.getCellData(rNum, "LeadStatus"))))
			{
				clickByXP(LeadSelectors.getOptionComBoxByXPath(ex.getCellData(rNum, "LeadStatus")));
			}
	
			clickByXP(LeadSelectors.getSaveButtonInputByXPath());
			
		}
		
		
		WebElement element = driver.findElement(By.xpath(LeadSelectors.getLeadTabByXPath()));
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", element);
		   
	    System.out.println("END ExECUTION");

	}
}
