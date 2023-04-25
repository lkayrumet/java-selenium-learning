package swag_labs.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebElement;

import softinnovas.library.Browser;
import softinnovas.library.ExcelFile;
import softinnovas.library.Reporter;
import softinnovas.pages.BasePage;

public class ProductsPage extends BasePage
{
	public ProductsPage(Browser br, Reporter r)
	{
		super(br, r);
	}
	
	public void addItemtoCart(String item)
	{
		br.clickByXP(getAddToCartButtonByXPath(item));
	}
	
	public int getCountRemoveButton()
	{
		return br.countElementsByXPath("//button[@class='btn btn_secondary btn_small btn_inventory']");
	}
	
	public String getItemNameText(String name)
	{
		
		return br.getTextByXPath("//div[text()='"+name+"']");
	}
	
	public String getItemPrice(String name)
	{
		
		return br.getTextByXPath("//div[text()='"+name+"']/parent::a/parent::div/following-sibling::div//div").replace("$", "");
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
	
	public double AddingItems(String dataFilePath, String sheetName)
	{		
		double total = 0;
		ExcelFile ex;
		ex = new ExcelFile(dataFilePath);
		ex.setSheetByName(sheetName);
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
	