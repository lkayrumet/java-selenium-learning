package softinnovas.pages;

import softinnovas.library.Browser;

public class BasePage 
{
	protected Browser br;
	public BasePage(Browser br)
	{
		this.br = br;
	}
	
	public void exitFrame()
	{
		br.exitFrame();
	}
	
}
