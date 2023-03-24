package Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.compress.archivers.zip.ZipSplitReadOnlySeekableByteChannel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import softinnovas.library.ExcelFile;
import softinnovas.library.LeadsTest;
import softinnovas.library.Reporter;
import softinnovas.pages.LeadSelectors;
import softinnovas.pages.LoginPage;
import softinnovas.pages.SalesForceDashboard;
import softinnovas.pages.SalesForceMain;

public class LoginTest 
{
		
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver;
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		Reporter r = new Reporter("C:\\DISCO D\\Selenium\\testResults.html");
		
		r.startTest("Testing SalesForce Login");
		
		
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.salesforce.com/");
	
		//get first shadow Dom
		WebElement prev_shadowDom_0 = driver.findElement(By.xpath(SalesForceMain.getPreFirstShadowDom()));  
		SearchContext shadowDom_0 = prev_shadowDom_0.getShadowRoot();

		
		//get Second shadow Dom
		WebElement loginButton = shadowDom_0.findElement(By.cssSelector(SalesForceMain.getPreSecondShadowDom()));
		loginButton.click();
		SearchContext  shadowDom_1 = loginButton.getShadowRoot();
		
		//click link to login page
		WebElement salesForceLogin = shadowDom_1.findElement(By.cssSelector(SalesForceMain.getLoginButton()));	
		salesForceLogin.click();
		
		
		r.info("Selected Login Button");
		
		//enter data to login 
		driver.findElement(By.xpath(LoginPage.getEmailInputXPath())).sendKeys("kayrumet-qpvt@force.com");
		
		driver.findElement(By.xpath(LoginPage.gePasswordInputXPath())).sendKeys("r9zhnEE44uwnzGi");
		
		driver.findElement(By.id(LoginPage.getLogInButtonId())).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(SalesForceDashboard.getViewProfileButtonXPath())).click();
		Thread.sleep(1000);
		String userName = driver.findElement(By.xpath(SalesForceDashboard.getUserNameXPath())).getText();
		
		if(userName.equals("Luis Perez"))
		{
			r.pass("Test Succesfully Passed");
		}
		else
		{
			r.fail("Test Failed");
		}		 
		r.endTest();
		
		r.startTest("Start 5 Lead adding Test");
		try 
		{
			LeadsTest leadTest = new LeadsTest();
			leadTest.newLeadTest(driver, "C:\\Users\\kayru\\eclipse-workspace\\selenium\\java-selenium-learning\\softinnovas\\testingData.xlsx");
			r.pass("Leads successfully added");
		}
		catch (Exception e) 
		{
			r.fail("Adding 5 Leads failed");
		}	
		
		r.endTest();
		
		
		r.flush();
		
	}

}
