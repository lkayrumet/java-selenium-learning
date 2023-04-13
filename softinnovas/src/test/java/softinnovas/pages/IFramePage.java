package softinnovas.pages;

import softinnovas.library.Browser;

public class IFramePage extends BasePage
{
	public IFramePage(Browser br)
	{
		super(br);
	}
		
	public void switchToFrame()
	{
		br.switchFrameByXPath(getFrameByXPath());
	}
	
	public String getFrameByXPath()
	{
		return "//iframe[@name='globalSqa']";
	}
	
	public String getImgSeleniunJava()
	{
		return "//img[@alt='Selenium Online Training']";
	}
		
	public void clickImageSeleniumJava()
	{
		br.clickByXP(getImgSeleniunJava());
	}
}
