package softinnovas.library;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile 
{
	String xlFilePath;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	HashMap<String, Integer> colNums = null;
	
	public ExcelFile(String excelFile)
	{
		try
		{
			this.xlFilePath = excelFile;
			FileInputStream f = new FileInputStream(new File(this.xlFilePath));
			wb = new XSSFWorkbook(f);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
	
	public void setSheetByName(String sheetName)
	{
		this.sheet = wb.getSheet(sheetName);
		populateColumnNums();
	}
	
	public void populateColumnNums()
	{
		colNums = new HashMap<String, Integer>();
		int colIndex = 0;
		
		Row row = sheet.getRow(0);
		Iterator<Cell> cells = row.cellIterator();
		while(cells.hasNext())
		{
			Cell cell = cells.next();
			String colName = cell.getStringCellValue();
			colNums.put(colName, colIndex);
			colIndex++;
		}
	}
	
	public int getColNumber(String colName)
	{
		return colNums.get(colName);
	}
	
	public String getCellData(int rowNum, String colName)
	{
		String ret ="";
		int colNum = getColNumber(colName);
		ret = getCellData(rowNum, colNum);
		return ret;
	}
	
	public String getCellData(int rowNum, int colNum)
	{
		String ret ="";
		
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);
		
		try
		{
			if(cell.getCellType() == CellType.STRING)
			{
				ret = cell.getStringCellValue();
			}
			else if (cell.getCellType() == CellType.NUMERIC)
			{
				ret = ""+cell.getNumericCellValue();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ret;
	}
	
	public XSSFSheet getSheet()
	{
		return sheet;
	}
	
}
