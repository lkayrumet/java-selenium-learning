package softinnovas.library;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser 
{
	WebDriver driver;
	
	public void init(String browser)
	{
		System.setProperty("webdriver.http.factory", "jdk-http-client");

		
		if (browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
	}
	
	public void navigateTo(String url)
	{
		driver.get(url);	
	}
	
	public void setTextByXPath(String xPath, String text)
	{
		driver.findElement(By.xpath(xPath)).sendKeys(text);
	}
	
	public void setText(String id, String text)
	{
		driver.findElement(By.id(id)).sendKeys(text);
	}
	
	public void setTextByName(String name, String text)
	{
		driver.findElement(By.name(name)).sendKeys(text);
	}
	
	public void click(String id)
	{
		driver.findElement(By.id(id)).click();;
	}
	
	public void clickByXP(String xp)
	{
		driver.findElement(By.xpath(xp)).click();
	}
	
	public void close()
	{
		driver.close();
	}
	
	public SearchContext findShadowRootByXPath(String xPath)
	{
		WebElement w = driver.findElement(By.xpath(xPath));
		return w.getShadowRoot();
	}
	
	public SearchContext findShadowRootByTagName(String tagName)
	{
		WebElement w = driver.findElement(By.tagName(tagName));
		return w.getShadowRoot();
	}
}

