package swag_labs.test;

import org.testng.annotations.Test;

import softinnovas.library.Browser;
import swag_labs.pages.LoginSwagLabs;
import swag_labs.pages.ProductsPage;

public class ProductsTest 
{
	@Test
	public void AddingItems()
	{
		Browser browser = new Browser("chrome");
				browser.navigateTo("https://www.saucedemo.com/");
		LoginSwagLabs login = new LoginSwagLabs(browser);
		login.setUser("standard_user");
		login.setPassword("secret_sauce");
		login.clickLoginButton();
		
		ProductsPage prod = new ProductsPage(browser);
		
		for(int i =0; i<5; i++)
		{
			prod.addItemtoCart();
		}		
	}
}
