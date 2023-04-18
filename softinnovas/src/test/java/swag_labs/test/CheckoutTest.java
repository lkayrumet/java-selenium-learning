package swag_labs.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import softinnovas.library.Browser;
import swag_labs.pages.CartSwagLabPage;
import swag_labs.pages.CheckoutPage;
import swag_labs.pages.LoginSwagLabs;
import swag_labs.pages.ProductsPage;

public class CheckoutTest 
{
	Browser br	= new Browser("chrome");
	LoginSwagLabs login = new LoginSwagLabs(br);
	ProductsPage prod = new ProductsPage(br);
	CartSwagLabPage cart = new CartSwagLabPage(br);
	CheckoutPage check = new CheckoutPage(br);
	
	@BeforeClass
	public void main()
	{
		br.navigateTo("https://www.saucedemo.com/");
		
		login.LoginRightCredentials();
		prod.AddingItems();
		cart.ClickCartIcon();
		cart.clickCheckoutButton();
	}
	
	@Test
	public void Continue()
	{
		check.fillCheckoutForm();
		check.clickContinueButton();
	}
	
	@Test
	public void CheckTitlePage()
	{		
		Assert.assertEquals(check.getCheckoutTitle(), "Checkout: Your Information");
	}
	
	@Test
	public void CheckCancelButton()
	{
		check.checkCancelButtonVisibleAndClickable();
		check.clickCancelButton();
		Assert.assertEquals(cart.validateCartPage(), "Your Cart");
	}
	
	@Test
	public void emptyName()
	{
		check.clickContinueButton();
		Assert.assertEquals(check.getMessageText(), "Error: First Name is required");
	}
	
	@Test
	public void emptyLastName()
	{
		check.setTextName("Luis");
		check.clickContinueButton();
		Assert.assertEquals(check.getMessageText(), "Error: Last Name is required");
	}
	
	@Test
	public void emptyZipCode()
	{
		check.setTextName("Luis");
		check.setTextLastName("Perez");
		check.clickContinueButton();
		Assert.assertEquals(check.getMessageText(), "Error: Postal Code is required");
	}
}
	