package Test;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import softinnovas.pages.LoginPage;
import softinnovas.pages.SalesForceMain;

public class LoginTest 
{
		
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver;
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
	//	WebDriverManager.firefoxdriver().setup();
	//	driver = new FirefoxDriver();
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
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

		//enter data to login 
		driver.findElement(By.xpath(LoginPage.getEmailInputXPath())).sendKeys("kayrumet-qpvt@force.com");
		
		driver.findElement(By.xpath(LoginPage.gePasswordInputXPath())).sendKeys("r9zhnEE44uwnzGi");
		
		driver.findElement(By.id(LoginPage.getLogInButtonId())).click();		 
		
	}

}
