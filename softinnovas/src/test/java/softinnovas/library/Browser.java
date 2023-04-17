package softinnovas.library;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import softinnovas.pages.AccountsTab;
import softinnovas.pages.Lead;

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
		if(waitClickableByXPath(xPath))
		{
			driver.findElement(By.xpath(xPath)).clear();
			driver.findElement(By.xpath(xPath)).sendKeys(text);
		}
		else
		{
			System.out.println("ERROR SEND KEYS BY XPATH");
		}
	}
	
	public void setText(String id, String text)
	{
		if(waitClickableByID(id))
		{
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(text);
		}
		else
		{
			System.out.println("ERROR SEND KEYS BY ID");
		}
	}
	
	public void setTextByName(String name, String text)
	{
		if(waitByName(name))
		{
			driver.findElement(By.name(name)).clear();
			driver.findElement(By.name(name)).sendKeys(text);
		}
		else
		{
			System.out.println("ERROR SEND KEYS BY NAME");
		}
	}
	
	public void clickByID(String id)
	{
		if(waitClickableByID(id))
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
		if(waitClickableByXPath(xp))
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
		if(waitClickableByXPath(xPath))
		{
		WebElement w = driver.findElement(By.xpath(xPath));
		return w.getShadowRoot();
		
		}
		else
		{
			System.out.println("ERROR GET SHADOW ROOT BY XPATH");
			return null;
		}
	}
	
	public SearchContext findShadowRootByTagName(String tagName)
	{
		if(waitByTagName(tagName))
		{
		WebElement w = driver.findElement(By.tagName(tagName));
		return w.getShadowRoot();
		}
		else
		{
			System.out.println("ERROR GET SHADOW ROOT BY TAGNAME");
			return null;
		}
	}
	
	public Boolean waitClickableByXPath(String xpath)
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
	
	public Boolean waitVisibleByXPath(String xpath)
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			return true;
		} 
		catch (Exception e) 
		{
			System.out.println("Error waitByXPath "+xpath);
		}
		
		return false;
	}
	
	
	
	public Boolean waitClickableByID(String id)
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
	
	public Boolean waitVisibleByID(String id)
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
			return true;
		} 
		catch (Exception e) 
		{
			System.out.println("Error waitByXId "+id);
		}
		
		return false;
	}
	
	public Boolean waitByName(String name)
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
			return true;
		} 
		catch (Exception e) 
		{
			System.out.println("Error waitByXPath "+name);
		}
		
		return false;
	}
	
	public Boolean waitByTagName(String tagName)
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(By.tagName(tagName)));
			return true;
		} 
		catch (Exception e) 
		{
			System.out.println("Error waitByXPath "+tagName);
		}
		
		return false;
	}
	
	public void executeJScToClick(String XPath)
	{
		if(waitClickableByXPath(XPath))
		{
			WebElement element = driver.findElement(By.xpath(XPath));
		    JavascriptExecutor executor = (JavascriptExecutor)driver;
		    executor.executeScript("arguments[0].click();", element);
		}
		else
		{
			System.out.println("ERROR EXECUTE JS FOR CLICK BY XPATH");
		}
	}
	
	public void switchFrameByXPath(String xpath)
	{
		WebElement e = driver.findElement(By.xpath(xpath));
	    driver.switchTo().frame(e);
	}
	
	public void switchFrameByID(String id)
	{
		WebElement e = driver.findElement(By.id(id));
	    driver.switchTo().frame(e);
	}
	
	public void exitFrame()
	{

	    driver.switchTo().defaultContent();
	}
	
	public void createAndSwitchTab()
	{
		driver.switchTo().newWindow(WindowType.TAB);
	}

	// Opens a new window and switches to new window
	public void createAndSwitchWindow()
	{
		driver.switchTo().newWindow(WindowType.WINDOW);
		
	}
	
	public String getTextByXPath(String xpath)
	{
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public String getTextByID(String id)
	{
		if(waitVisibleByID(id))
		{
			return driver.findElement(By.id(id)).getText();
		}
		else
		{
			System.out.println("ERROR VISIBLE BY ID");
			return "";			
		}
	}
	
	public String getButtonTextByID(String id)
	{
		if(waitVisibleByID(id))
		{
			return driver.findElement(By.id(id)).getAttribute("value");
		}
		else
		{
			System.out.println("ERROR GET TEXT BY ID");
			return "";			
		}
	}
	
	public String getButtonTextByXPath(String xpath)
	{
		if(waitVisibleByID(xpath))
		{
			return driver.findElement(By.xpath(xpath)).getAttribute("value");
		}
		else
		{
			System.out.println("ERROR GET TEXT BY ID");
			return "";			
		}
	}
	
	public int countElementsByXPath(String xpath)
	{
		if(waitVisibleByXPath(xpath))
		{
			return driver.findElements(By.xpath(xpath)).size();
		}
		return 0;
	}
	
	public List<WebElement> getElementsByXPath(String xpath)
	{
		if(waitVisibleByXPath(xpath))
		{
			return driver.findElements(By.xpath(xpath));
		}
		return null;
	}
	
	public int getElementsByID(String id)
	{
		if(waitVisibleByID(id))
		{
			return driver.findElements(By.id(id)).size();
		}
		return 0;
	}
	
	public boolean isDisplayedByID( String id) 
	{
        try 
        {
            return driver.findElement(By.id(id)).isDisplayed();
        } 
        catch (Exception e) 
        {
            return false;
        }
    }
	
	public boolean isDisplayedByXPath( String xpath) 
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
			return true;
		} 
		catch (Exception e) 
		{
			System.out.println("Error waitByXPath "+xpath);
		}
		
		return false;
    }
}

