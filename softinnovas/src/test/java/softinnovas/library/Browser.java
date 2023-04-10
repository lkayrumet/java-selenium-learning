package softinnovas.library;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser 
{
	protected WebDriver driver;
	
	public Browser()
	{
		
	}
	
	public Browser(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public Browser(String browser)
	{
		// TODO Auto-generated constructor stub
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public WebDriver getDriver()
	{
		return this.driver;
	}
	
	public void navigateTo(String url)
	{
		driver.get(url);	
	}
	
	public void setTextByXPath(String xPath, String text)
	{
		if(waitByXPath(xPath))
		{
			driver.findElement(By.xpath(xPath)).sendKeys(text);
		}
		else
		{
			System.out.println("ERROR SEND KEYS BY XPATH");
		}
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
		if(waitByID(id))
		{
			driver.findElement(By.id(id)).click();
		}
		else
		{
			System.out.println("ERROR CLICK BY ID");
		}
	}
	
	public void clickByXP(String xp)
	{
		if(waitByXPath(xp))
		{
			driver.findElement(By.xpath(xp)).click();
		}
		else
		{
			System.out.println("ERROR CLICK BY XPATH");
		}
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
	
	public Boolean waitByXPath(String xpath)
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			return true;
		} 
		catch (Exception e) 
		{
			System.out.println("Error waitByXPath "+xpath);
		}
		
		return false;
	}
	
	public Boolean waitByID(String id)
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
			return true;
		} 
		catch (Exception e) 
		{
			System.out.println("Error waitByXId "+id);
		}
		
		return false;
	}
}

