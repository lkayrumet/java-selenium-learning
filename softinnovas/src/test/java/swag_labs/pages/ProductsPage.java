package swag_labs.pages;

import softinnovas.library.Browser;
import softinnovas.pages.BasePage;

public class ProductsPage extends BasePage
{
	public ProductsPage(Browser br)
	{
		super(br);
	}
	
	public void addItemtoCart()
	{
		br.clickByXP("//button[@class='btn btn_primary btn_small btn_inventory']");
	}
	
	
}
