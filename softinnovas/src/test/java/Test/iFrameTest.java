package Test;

import softinnovas.library.Browser;
import softinnovas.pages.IFramePage;

public class iFrameTest
{
	public static void main(String arg[])
	{
		Browser br = new Browser("chrome");
		br.navigateTo("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
		
		
		
		IFramePage iframe = new IFramePage(br);	
		
		iframe.switchToFrame();
		iframe.clickImageSeleniumJava();
		iframe.exitFrame();
		
		
		//br.createAndSwitchTab();
		//br.createAndSwitchWindow();
	}
}
