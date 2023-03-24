package softinnovas.library;

import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import softinnovas.pages.LeadSelectors;

public class LeadsTest 
{
	ExcelFile ex; 
	
	public void newLeadTest(WebDriver driver, String excelData) throws InterruptedException
	{
		this.ex = new ExcelFile(excelData);
		this.ex.setSheetByName("Leads");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		//Select and click tab Leads
				
		Iterator<Row> rows = ex.getSheet().iterator();
		rows.next();
		
		
		while(rows.hasNext())
		{
			Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath(LeadSelectors.getLeadTabByXPath()));
		    JavascriptExecutor executor = (JavascriptExecutor)driver;
		    executor.executeScript("arguments[0].click();", element);
		    Thread.sleep(3000);
		    
			Row row = rows.next();
			int rNum = row.getRowNum();
			
			driver.findElement(By.xpath(LeadSelectors.getNewButtonByXPath())).click();
			Thread.sleep(500);


			driver.findElement(By.xpath(LeadSelectors.getFirstNameInputeByXPath())).sendKeys(ex.getCellData(rNum, "FirstName"));
			driver.findElement(By.xpath(LeadSelectors.getLastNameInputByXPath())).sendKeys(ex.getCellData(rNum, "LastName"));
			driver.findElement(By.xpath(LeadSelectors.getCompanyInputByXPath())).sendKeys(ex.getCellData(rNum, "Company"));
			
			driver.findElement(By.xpath(LeadSelectors.getLeadStatusComBoxInputById())).click();
			Thread.sleep(500);
			
			
			driver.findElement(By.xpath(LeadSelectors.getOptionComBoxByXPath(ex.getCellData(rNum, "LeadStatus")))).click();
			
			
			driver.findElement(By.xpath(LeadSelectors.getSaveButtonInputByXPath())).click();
			//Thread.sleep(10000);
			
		}
		
		
		WebElement element = driver.findElement(By.xpath(LeadSelectors.getLeadTabByXPath()));
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", element);
		   
	    System.out.println("END ExECUTION");

	}
}
