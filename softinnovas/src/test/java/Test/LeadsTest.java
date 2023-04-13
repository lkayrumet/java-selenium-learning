package Test;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import softinnovas.library.Browser;
import softinnovas.library.ExcelFile;
import softinnovas.pages.Lead;
import softinnovas.pages.LoginPage;

public class LeadsTest extends Browser
{
	
	public static void main(String arg[]) throws InterruptedException
	{
		Browser browser = new Browser("chrome");
		browser.navigateTo("https://login.salesforce.com/");
		
		LoginPage login = new LoginPage(browser);
		login.setUserEmail("kayrumet-qpvt@force.com");
		login.setPassword("r9zhnEE44uwnzGi");
		login.clickLoginButton();
		
		ExcelFile ex; 
		
		Lead leadTab = new Lead(browser);
		
		try 
		{
			ex = new ExcelFile("C:\\Users\\kayru\\eclipse-workspace\\selenium\\java-selenium-learning\\softinnovas\\testingData.xlsx");
			ex.setSheetByName("Leads");
			Iterator<Row> rows = ex.getSheet().iterator();
			rows.next();
			
			while(rows.hasNext())
			{
				leadTab.clickLeadsTab();
				leadTab.clickNewLeadButton();
					    
				Row row = rows.next();
				int rNum = row.getRowNum();
				
				leadTab.setFirstName(ex.getCellData(rNum, "FirstName"));
				leadTab.setLastName( ex.getCellData(rNum, "LastName"));
				leadTab.setCompany(ex.getCellData(rNum, "Company"));
					
				leadTab.clickComboboxLeadStatus();
				leadTab.clickLeadStatusOption(ex.getCellData(rNum, "LeadStatus"));
				leadTab.clickSaveButton();
				
			}
			
			leadTab.clickLeadsTab();
			   
		    System.out.println("END ExECUTION");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Select and click tab Leads
				
		
		
		
		
		
		
	

	}
}
