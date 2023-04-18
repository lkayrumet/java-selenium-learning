package swag_labs.pages;

import softinnovas.library.Browser;
import softinnovas.pages.BasePage;

public class CheckoutPage extends BasePage
{
	public CheckoutPage(Browser br)
	{
		super(br);
	}
	
	public String getCheckoutTitle()
	{
		return br.getTextByXPath("//span[@class='title']");
	}
	
	public void checkCancelButtonVisibleAndClickable()
	{
		br.waitVisibleByID("cancel");
		br.waitClickableByID("cancel");
	}
	
	public void clickCancelButton()
	{
		br.clickByID("cancel");
	}
	
	public void fillCheckoutForm()
	{
		br.setText("first-name", "Luis");
		br.setText("last-name", "Perez");
		br.setText("postal-code", "78634");
	}
	
	public void clickContinueButton()
	{
		br.clickByID("continue");
	}
	
	public void setTextName(String name)
	{
		br.setText("first-name", name);
	}
	
	public void setTextLastName(String lastName)
	{
		br.setText("last-name", lastName);
	}
	
	public void setTextZipCode(String zip)
	{
		br.setText("postal-code", zip);
	}
	
	public String getMessageText()
	{
		return br.getTextByXPath("//h3");
	}
}
