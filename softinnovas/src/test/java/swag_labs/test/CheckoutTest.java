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
	Reporter report; 
	LoginSwagLabs login = new LoginSwagLabs(br, report);
	ProductsPage prod = new ProductsPage(br, report);
	CartSwagLabPage cart = new CartSwagLabPage(br, report);
	CheckoutPage check = new CheckoutPage(br, report);
	
	double total =0;
	
	@BeforeClass
	public void main()
	{
		
		br.navigateTo("https://www.saucedemo.com/");
		
		String date =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		report= new Reporter("C:\\DISCO D\\Selenium\\Checking_Swag_Test_Result_"+date+".html");
		
		String datafilePath = "C:\\Users\\kayru\\eclipse-workspace\\selenium\\java-selenium-learning\\softinnovas\\Data_Test_Swag_Web_Site.xlsx";
		String sheetName = "Shopping_items";

		login.LoginRightCredentials();
		total = prod.AddingItems(datafilePath, sheetName);
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
			check.verify(check.getCheckoutOverview(),"Checkout: Overview");
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
			check.verify(check.getCheckoutTitle(), "Checkout: Your Information");
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
			check.verify(cart.validateCartPage(), "Your Cart");
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
			check.verify(check.getErrorMessageText(), "Error: First Name is required");
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
			check.verify(check.getErrorMessageText(), "Error: Last Name is required");
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
			check.verify(check.getErrorMessageText(), "Error: Postal Code is required");
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
			check.verify(check.getLastMessage(), "Thank you for your order!");
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
			check.verify(check.getTotalPrice(), total);
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
	