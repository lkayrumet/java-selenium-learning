package swag_labs.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import softinnovas.library.Browser;
import softinnovas.library.ExcelFile;
import softinnovas.library.Reporter;
import swag_labs.pages.CartSwagLabPage;
import swag_labs.pages.LoginSwagLabs;
import swag_labs.pages.ProductsPage;

public class CartTest
{
	Browser browser = new Browser("chrome");
	LoginSwagLabs login = new LoginSwagLabs(browser);
	ProductsPage prod = new ProductsPage(browser);
	CartSwagLabPage cart = new CartSwagLabPage(browser);
	double total = 0;
	Reporter report; 
	
	@BeforeClass
	public void main()
	{
		String date =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		report= new Reporter("C:\\DISCO D\\Selenium\\Cart_Swag_Test_Result_"+date+".html");
		browser.navigateTo("https://www.saucedemo.com/");
		login.LoginRightCredentials();
		prod.AddingItems();
	}
	@Test
	public void checkCartIconIsVisibleAndClickable()
	{
		report.startTest("Cart Cart visible and clickable initialized");
		try
		{
			cart.checkCartIconIsVisibleAndClicable();
			report.pass("Test completed successfully");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void clickCartIcon()
	{
		report.startTest("Cart click icon test initialized");
		try 
		{
			cart.ClickCartIcon();
			Assert.assertEquals(cart.validateCartPage(), "Your Cart");
			cart.ClickContinueShopping();
			report.pass("Test completed successfully");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void clickContinueShopping()
	{
		report.startTest("Cart click continue button test initialized");
		try
		{
			cart.ClickCartIcon();
			cart.ClickContinueShopping();
			Assert.assertEquals(cart.getProductsTitle(), "Products");
			report.pass("Test completed successfully");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
		
	}
	
	@Test
	public void removeItemFromCart()
	{
		report.startTest("Cart remove item from list test initialized");
		try
		{
			cart.ClickCartIcon();
			ExcelFile ex;
			ex = new ExcelFile("C:\\Users\\kayru\\eclipse-workspace\\selenium\\java-selenium-learning\\softinnovas\\Data_Test_Swag_Web_Site.xlsx");
			ex.setSheetByName("Shopping_items");
			Iterator<Row> rows = ex.getSheet().iterator(); 
			rows.next();
			
			while(rows.hasNext())
			{
				Row row = rows.next(); 
				int rNum = row.getRowNum();
		
				cart.removeItem(ex.getCellData(rNum, "Remove"));
				cart.findRemoveButtonByXPath(ex.getCellData(rNum, "Remove"));
			}
			cart.ClickContinueShopping();
			report.pass("Test completed successfully");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void checkout()
	{
		report.startTest("Cart clic checkout button test initialized");
		try
		{
			cart.ClickCartIcon();
			cart.clickCheckoutButton();
			Assert.assertEquals(cart.getCheckoutTitle(), "Checkout: Your Information");
			cart.clickCancelButton();
			cart.ClickContinueShopping();
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@AfterClass
	public void EndCartTest()
	{
		report.flush();
		browser.close();
	}
}


