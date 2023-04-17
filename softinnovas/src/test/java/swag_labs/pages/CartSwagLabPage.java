package swag_labs.pages;

import org.testng.Assert;

import softinnovas.library.Browser;
import softinnovas.pages.BasePage;

public class CartSwagLabPage extends BasePage
{
	public CartSwagLabPage(Browser br)
	{
		super(br);
	}
	
	public void checkCartIconIsVisibleAndClicable()
	{
		br.waitVisibleByXPath("//a[@class='shopping_cart_link']");
		br.waitClickableByXPath("//a[@class='shopping_cart_link']");
	}
	
	public void ClickCartIcon()
	{
		br.clickByXP("//a[@class='shopping_cart_link']");
	}
	
	public void ClickContinueShopping()
	{
		br.clickByID("continue-shopping");
	}
	
	public String getProductsTitle()
	{
		return br.getTextByXPath("//span[@class='title']");
	}
	
	public void removeItem(String item)
	{
		br.clickByXP("//div[text()='"+item+"']/parent::a/following-sibling::div//button");
	}
	
	public void findRemoveButtonByXPath(String item)
	{
		Assert.assertEquals(br.getButtonTextByXPath("//div[text()='"+item+"']/parent::a/following-sibling::div//button"), "");
	}
	
	public String validateCartPage()
	{
		return br.getTextByXPath("//span[@class='title']");
	}
	
	public void clickCheckoutButton()
	{
		br.clickByID("checkout");
	}
	
	public String getCheckoutTitle()
	{
		return br.getTextByXPath("//span[@class='title']");
	}
	
	public void clickCancelButton()
	{
		br.clickByID("cancel");
	}
}
