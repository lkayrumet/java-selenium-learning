package swag_labs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import softinnovas.library.Browser;
import softinnovas.pages.BasePage;

public class ProductsPage extends BasePage
{
	public ProductsPage(Browser br)
	{
		super(br);
	}
	
	public void addItemtoCart(int index)
	{
		br.clickByXP("(//button[@class='btn btn_primary btn_small btn_inventory'])["+index+"]");
	}
	
	public int getCountRemoveButton()
	{
		return br.countElementsByXPath("//button[@class='btn btn_secondary btn_small btn_inventory']");
	}
	
	public String getSauceLabsBackpackText()
	{
		return br.getTextByXPath("//a[@id='item_4_title_link']//div[@class='inventory_item_name']");
	}
	
	public String getSauceLabsBackpackPrice()
	{
		return br.getTextByXPath("//a[@id='item_4_title_link']/parent::div/following-sibling::div//div");
	}
	
	public String getSauceLabsBikeLightText()
	{
		return br.getTextByXPath("//a[@id='item_0_title_link']//div[@class='inventory_item_name']");
	}
	
	public String getSauceLabsBikeLightPrice()
	{
		return br.getTextByXPath("//a[@id='item_0_title_link']/parent::div/following-sibling::div//div");
	}
	
	public String getSauceLabsBoltT_ShirtText()
	{
		return br.getTextByXPath("//a[@id='item_1_title_link']//div[@class='inventory_item_name']");
	}
	
	public String getSauceLabsBoltT_ShirtPrice()
	{
		return br.getTextByXPath("//a[@id='item_1_title_link']/parent::div/following-sibling::div//div");
	}
	
	public String getSauceLabsFleeceJacketText()
	{
		return br.getTextByXPath("//a[@id='item_5_title_link']//div[@class='inventory_item_name']");
	}
	
	public String getSauceLabsFleeceJacketPrice()
	{
		return br.getTextByXPath("//a[@id='item_5_title_link']/parent::div/following-sibling::div//div");
	}
	
	public String getSauceLabsOnesieText()
	{
		return br.getTextByXPath("//a[@id='item_2_title_link']//div[@class='inventory_item_name']");
	}
	
	public String getSauceLabsOnesiePrice()
	{
		return br.getTextByXPath("//a[@id='item_2_title_link']/parent::div/following-sibling::div//div");
	}
	
	public String getTestallTheThingsT_ShirtRedText()
	{
		return br.getTextByXPath("//a[@id='item_3_title_link']//div[@class='inventory_item_name']");
	}
	
	public String getTestallTheThingsT_ShirtRedPrice()
	{
		return br.getTextByXPath("//a[@id='item_3_title_link']/parent::div/following-sibling::div//div");
	}
	
	public int countSortOptions()
	{
		br.clickByXP("//select");
		return br.countElementsByXPath("//select//option");
	}
	
	public String getDefaultComboboxOption()
	{
		return br.getTextByXPath("//span[@class='active_option']");
	}
	
	public List<String> getElementsStringList()
	{
		List<WebElement> list = br.getElementsByXPath("//div[@class='inventory_item_name']");
		List<String> itemNames = new ArrayList<String>();
		for(int i=0; i<list.size(); i++)
		{
			itemNames.add(list.get(i).getText());
		}
		
		return itemNames;
	}
	
	public List<Double> getElementsPriceList()
	{
		List<WebElement> list = br.getElementsByXPath("//div[@class='inventory_item_price']");
	
		List<Double> itemNames = new ArrayList<Double>();
		
		for(int i=0; i<list.size(); i++)
		{
			double j = Double.parseDouble(list.get(i).getText().replace("$", ""));
			itemNames.add(j);
		}
		return itemNames;
	}
	
	public void selectAtoZOrder()
	{
		br.clickByXP("//select");
		br.clickByXP("//select//option[@value='az']");
	}
	
	public void selectZtoAOrder()
	{
		br.clickByXP("//select");
		br.clickByXP("//select//option[@value='za']");
	}
	
	public void selectPriceLowToHighOrder()
	{
		br.clickByXP("//select");
		br.clickByXP("//select//option[@value='lohi']");
	}
	
	public void selectPriceHighToLowOrder()
	{
		br.clickByXP("//select");
		br.clickByXP("//select//option[@value='hilo']");
	}
}
	