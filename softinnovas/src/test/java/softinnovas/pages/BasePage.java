package softinnovas.pages;



import java.util.List;

import softinnovas.library.Browser;
import softinnovas.library.Reporter;

public class BasePage 
{
	protected Browser br;
	protected Reporter reporter;
	
	public BasePage(Browser br, Reporter r)
	{
		this.br = br;
		this.reporter = r;
	}
	
	public void exitFrame()
	{	
		br.exitFrame();
	}
	
	public void verify(String expected, String actual)
	{
		if(expected.equals(actual))
		{
			reporter.pass("Test completed successfully ");
		}
		else
		{
			reporter.fail("Test Failed.");
		}
	}
		
	public void verify(double expected, double actual)
	{
		if(expected == actual)
		{
			reporter.pass("Test completed successfully ");
		}
		else
		{
			reporter.fail("Test Failed.");
		}
	}
	
	public void verify(int expected, int actual)
	{
		if(expected == actual)
		{
			reporter.pass("Test completed successfully ");
		}
		else
		{
			reporter.fail("Test Failed.");
		}
	}
	
	public void verify(List<String> expected, List<String> actual)
	{
		if(expected.equals(actual))
		{
			reporter.pass("Test completed successfully ");
		}
		else
		{
			reporter.fail("Test Failed.");
		}
	}
}
