package swag_labs.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import softinnovas.library.Browser;
import softinnovas.library.Reporter;
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
	
	Reporter report; 
	
	double total =0;
	
	@BeforeClass
	public void main()
	{
		
		br.navigateTo("https://www.saucedemo.com/");
		
		String date =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		report= new Reporter("C:\\DISCO D\\Selenium\\Checking_Swag_Test_Result_"+date+".html");
		
		login.LoginRightCredentials();
		total = prod.AddingItems();
		cart.ClickCartIcon();
		cart.clickCheckoutButton();
	}
	
	@Test
	public void Continue()
	{
		report.startTest("Checkout continue button test initialized");
		try
		{
			check.fillCheckoutForm();
			check.clickContinueButton();
			Assert.assertEquals(check.getCheckoutOverview(),"Checkout: Overview");
			report.pass("Test completed successfully");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void CheckTitlePage()
	{		
		report.startTest("Checkout check title test initialized");
		try 
		{
			Assert.assertEquals(check.getCheckoutTitle(), "Checkout: Your Information");
			report.pass("Test completed successfully");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void CheckCancelButton()
	{
		report.startTest("Checkout cancel button test initialized");
		try 
		{
			check.checkCancelButtonVisibleAndClickable();
			check.clickCancelButton();
			Assert.assertEquals(cart.validateCartPage(), "Your Cart");
			report.pass("Test completed successfully");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void emptyName()
	{
		report.startTest("Checkout empty name test initialized");
		try 
		{
			check.clickContinueButton();
			Assert.assertEquals(check.getErrorMessageText(), "Error: First Name is required");
			report.pass("Test completed successfully");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void emptyLastName()
	{
		report.startTest("Checkout empty last name test initialized");
		try
		{
			check.setTextName("Luis");
			check.clickContinueButton();
			Assert.assertEquals(check.getErrorMessageText(), "Error: Last Name is required");
			report.pass("Test completed successfully");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void emptyZipCode()
	{
		report.startTest("Checkout empty Zip code test initialized");
		try
		{
			check.setTextName("Luis");
			check.setTextLastName("Perez");
			check.clickContinueButton();
			Assert.assertEquals(check.getErrorMessageText(), "Error: Postal Code is required");
			report.pass("Test completed successfully");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void FinishShopProcess()
	{
		report.startTest("Checkout End to End test initialized");
		try
		{
			check.fillCheckoutForm();
			check.clickContinueButton();
			check.clickfinishButton();
			Assert.assertEquals(check.getLastMessage(), "Thank you for your order!");
			report.pass("Test completed successfully");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@Test
	public void CheckTotalPriceProcess()
	{
		report.startTest("Checkout check total price test initialized");
		try
		{
			check.fillCheckoutForm();
			check.clickContinueButton();
			Assert.assertEquals(check.getTotalPrice(), total);
			report.pass("Test completed successfully");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			report.fail("Test Failed.");
		}
	}
	
	@AfterClass
	public void endTest()
	{
		report.flush();
		br.close();
	}
	
	
}
	