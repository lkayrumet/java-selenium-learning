package swag_labs.test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

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
import softinnovas.library.Reporter;
import swag_labs.pages.LoginSwagLabs;
import swag_labs.pages.ProductsPage;

public class ProductsTest 
{
	Browser browser = new Browser("chrome");
	LoginSwagLabs login = new LoginSwagLabs(browser);
	ProductsPage prod = new ProductsPage(browser);
	Reporter report; 
	
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
	public void CheckProductsName()
	{
		report.startTest("Products check price and Products name test initialized");
		try
		{
			Assert.assertEquals(prod.getSauceLabsBackpackText(), "Sauce Labs Backpack");
			Assert.assertEquals(prod.getSauceLabsBoltT_ShirtText(), "Sauce Labs Bolt T-Shirt");
			Assert.assertEquals(prod.getSauceLabsBikeLightText(), "Sauce Labs Bike Light");
			Assert.assertEquals(prod.getSauceLabsFleeceJacketText(), "Sauce Labs Fleece Jacket");
			Assert.assertEquals(prod.getSauceLabsOnesieText(), "Sauce Labs Onesie");
			Assert.assertEquals(prod.getTestallTheThingsT_ShirtRedText(), "Test.allTheThings() T-Shirt (Red)");	
			
			Assert.assertEquals(prod.getSauceLabsBackpackPrice(), "$29.99");
			Assert.assertEquals(prod.getSauceLabsBoltT_ShirtPrice(), "$15.99");
			Assert.assertEquals(prod.getSauceLabsBikeLightPrice(), "$9.99");
			Assert.assertEquals(prod.getSauceLabsFleeceJacketPrice(), "$49.99");
			Assert.assertEquals(prod.getSauceLabsOnesiePrice(), "$7.99");
			Assert.assertEquals(prod.getTestallTheThingsT_ShirtRedPrice(), "$15.99");	
			report.pass("Test completed successfully");
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
			Assert.assertEquals(prod.countSortOptions(), 4);
			System.out.println(browser.getTextByXPath("//span[@class='active_option']"));
			report.pass("Test completed successfully");
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
			Assert.assertEquals(prod.getDefaultComboboxOption(), "Name (A to Z)");
			report.pass("Test completed successfully");
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
			prod.selectAtoZOrder();
			List<String> listItemsAtoZ = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", 
														"Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");
			Collections.sort(listItemsAtoZ);
			Assert.assertEquals(prod.getElementsStringList(), listItemsAtoZ);
			report.pass("Test completed successfully");
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
			prod.selectZtoAOrder();
			List<String> listItemsAtoZ = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", 
														"Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");
			Collections.sort(listItemsAtoZ, Collections.reverseOrder());
			Assert.assertEquals(prod.getElementsStringList(), listItemsAtoZ);
			report.pass("Test completed successfully");
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
			prod.selectPriceLowToHighOrder();
			List<Double> listItemsLowToHigh = Arrays.asList(15.99, 7.99, 49.99, 15.99, 9.99, 29.99);
			Collections.sort(listItemsLowToHigh);
			Assert.assertEquals(prod.getElementsPriceList(), listItemsLowToHigh);
			report.pass("Test completed successfully");
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
			prod.selectPriceHighToLowOrder();
			List<Double> listItemsHightoLow = Arrays.asList(15.99, 7.99, 49.99, 15.99, 9.99, 29.99);
			Collections.sort(listItemsHightoLow, Collections.reverseOrder());
			Assert.assertEquals(prod.getElementsPriceList(), listItemsHightoLow);
			report.pass("Test completed successfully");
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
