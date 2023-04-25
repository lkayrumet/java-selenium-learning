package swag_labs.test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import softinnovas.library.Browser;
import softinnovas.library.ExcelFile;
import softinnovas.library.Reporter;
import swag_labs.pages.LoginSwagLabs;
import swag_labs.pages.ProductsPage;

public class ProductsTest 
{
	Browser browser = new Browser("chrome");
	Reporter report; 
	LoginSwagLabs login = new LoginSwagLabs(browser, report);
	ProductsPage prod = new ProductsPage(browser, report);
	
	
	@BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("Executed before suite");
	}
	
	@BeforeTest
	public void BeforeTest()
	{
		System.out.println("Executed before test");
	}
	
	@BeforeClass
	public void BeforeClass()
	{
		String date =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		report= new Reporter("C:\\DISCO D\\Selenium\\Products_Swag_Test_Result_"+date+".html");
		
		browser.navigateTo("https://www.saucedemo.com/");
		
		login.setUser("standard_user");
		login.setPassword("secret_sauce");
		login.clickLoginButton();
		
		System.out.println("Executed before class");
	}
	
	@BeforeMethod
	public void BeforeMethod()
	{
		System.out.println("Executed before method");
	}
		
	@BeforeGroups
	public void BeforeGropus()
	{
		System.out.println("Executed before groups");
	}
	
	
	@Test
	public void AddItems()
	{
		String datafilePath = "C:\\Users\\kayru\\eclipse-workspace\\selenium\\java-selenium-learning\\softinnovas\\Add_Items_From_Cart_Test_Swag_Web_Site.xlsx";
		String sheetName = "Shopping_items";
		
		prod.AddingItems(datafilePath, sheetName);
	}
	
	
	@Test
	public void CheckProductsName()
	{
		report.startTest("Products check price and Products name test initialized");
		try
		{
			String datafilePath = "C:\\Users\\kayru\\eclipse-workspace\\selenium\\java-selenium-learning\\softinnovas\\Items_Names_From_Cart_Test_Swag_Web_Site.xlsx";
			String sheetName = "Shopping_items";
			
			ExcelFile ex;
			ex = new ExcelFile(datafilePath);
			ex.setSheetByName(sheetName);
			
			Iterator<Row> rows = ex.getSheet().iterator(); 
			rows.next();
			
			while(rows.hasNext())
			{
				Row row = rows.next(); 
				int rNum = row.getRowNum();
				prod.verify(prod.getItemNameText(ex.getCellData(rNum, "Item_Names")), ex.getCellData(rNum, "Item_Names"));
				prod.verify(prod.getItemPrice(ex.getCellData(rNum, "Price")), ex.getCellData(rNum, "Price"));
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void CheckComboBoxOptions()
	{
		report.startTest("Products check combobox options test initialized");
		try
		{
			prod.verify(prod.countSortOptions(), 4);
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void CheckDefaultOption()
	{
		report.startTest("Products check combobox default option test initialized");
		try
		{
			prod.verify(prod.getDefaultComboboxOption(), "Name (A to Z)");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void CheckSortAtoZ()
	{
		report.startTest("Products check sort A to Z test initialized");
		try
		{
			List<String> beforeSort = prod.getElementsStringList();
			prod.selectAtoZOrder();
			
			Collections.sort(beforeSort);
			prod.verify(prod.getElementsStringList(), beforeSort);
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void CheckSortZtoA()
	{
		report.startTest("Products check sort Z to A test initialized");
		try
		{
			List<String> beforeSort = prod.getElementsStringList();
			prod.selectZtoAOrder();

			Collections.sort(beforeSort, Collections.reverseOrder());
			prod.verify(prod.getElementsStringList(), beforeSort);
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void CheckSortLowToHigh()
	{
		report.startTest("Products check sort low to high price test initialized");
		try
		{

			List<Double> beforeList = prod.getElementsPriceList();			
			prod.selectPriceLowToHighOrder();
			Collections.sort(beforeList);
			if(prod.getElementsPriceList().equals(beforeList))
			{
				report.pass("Test completed successfully ");
			}
			else
			{
				report.fail("Test Failed.");
			}

		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void CheckSortHighToLow()
	{
		report.startTest("Products check sort high to low price test initialized");
		try
		{
			List<Double> beforeList = prod.getElementsPriceList();	
			prod.selectPriceHighToLowOrder();

			Collections.sort(beforeList, Collections.reverseOrder());

			if(prod.getElementsPriceList().equals(beforeList))
			{
				report.pass("Test completed successfully ");
			}
			else
			{
				report.fail("Test Failed.");
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
		
	@AfterGroups
	public void AfterGroups()
	{
		System.out.println("Executed after groups");
	}
	
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("Executed after method");
	}
	
	@AfterClass
	public void AfterClass()
	{
		report.flush();
		browser.close();
		System.out.println("Executed after class");
	}

	@AfterTest
	public void AfterTest()
	{
		System.out.println("Executed after test");
	}
	
	@AfterSuite
	public void AfterSuite()
	{
		System.out.println("Executed after suite");
	}
}
