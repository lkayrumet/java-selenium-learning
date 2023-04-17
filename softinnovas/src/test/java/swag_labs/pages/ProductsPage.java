package swag_labs.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebElement;

import softinnovas.library.Browser;
import softinnovas.library.ExcelFile;
import softinnovas.pages.BasePage;

public class ProductsPage extends BasePage
{
	public ProductsPage(Browser br)
	{
		super(br);
	}
	
	public void addItemtoCart(String item)
	{
		br.clickByXP(getAddToCartButtonByXPath(item));
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
	
	public String getAddToCartButtonByXPath(String item)
	{
		return "//div[text()='"+item+"']/parent::a/parent::div/following-sibling::div//button";
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
	
	public double AddingItems()
	{		
		double total = 0;
		ExcelFile ex;
		ex = new ExcelFile("C:\\Users\\kayru\\eclipse-workspace\\selenium\\java-selenium-learning\\softinnovas\\Data_Test_Swag_Web_Site.xlsx");
		ex.setSheetByName("Shopping_items");
		Iterator<Row> rows = ex.getSheet().iterator(); 
		rows.next();
		
		while(rows.hasNext())
		{
			Row row = rows.next(); 
			int rNum = row.getRowNum();
			double j = Double.parseDouble(br.getTextByXPath("//div[text()='"+ex.getCellData(rNum, "Item_Names")+
															"']/parent::a/parent::div/following-sibling::div//div").replace("$", ""));
			addItemtoCart(ex.getCellData(rNum, "Item_Names"));
			total+=j;
		}
		return total;
	}
}
	