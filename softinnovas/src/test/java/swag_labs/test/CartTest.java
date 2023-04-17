package swag_labs.test;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import softinnovas.library.Browser;
import softinnovas.library.ExcelFile;
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
	
	@BeforeClass
	public void main()
	{
		browser.navigateTo("https://www.saucedemo.com/");
		login.LoginRightCredentials();
		prod.AddingItems();
	}
	@Test
	public void checkCartIconIsVisibleAndClickable()
	{
		cart.checkCartIconIsVisibleAndClicable();
	}
	
	@Test
	public void clickCartIcon()
	{
		cart.ClickCartIcon();
		Assert.assertEquals(cart.validateCartPage(), "Your Cart");
		cart.ClickContinueShopping();
	}
	
	@Test
	public void clickContinueShopping()
	{
		cart.ClickCartIcon();
		cart.ClickContinueShopping();
		Assert.assertEquals(cart.getProductsTitle(), "Products");
		
	}
	
	@Test
	public void removeItemFromCart()
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
	}
	
	@Test
	public void checkout()
	{
		cart.ClickCartIcon();
		cart.clickCheckoutButton();
		Assert.assertEquals(cart.getCheckoutTitle(), "Checkout: Your Information");
		cart.clickCancelButton();
		cart.ClickContinueShopping();
	}
}


