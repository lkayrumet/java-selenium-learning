package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import softinnovas.pages.LoginPage;
import softinnovas.pages.SalesForceMain;

public class FirefoxFoxTester 
{
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver;
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
	
		driver.manage().window().maximize();
		
		driver.get("https://www.salesforce.com/");
		
	
		Thread.sleep(3000);
		
		//get first shadow Dom
		WebElement prev_shadowDom_0 = driver.findElement(By.xpath(SalesForceMain.getPreFirstShadowDom()));  
		SearchContext shadowDom_0 = prev_shadowDom_0.getShadowRoot();
		
	
		WebElement loginButton = shadowDom_0.findElement(By.cssSelector("*"));
		
		
		System.out.println(prev_shadowDom_0.getTagName());
		
		
		
		driver.quit();

		//List<WebElement> lista = shadowDom_0.findElements(By.cssSelector("*"));
		//for (int i = 0; i < lista.size(); i++) 
		//{
		//	System.out.println(lista.get(i).getTagName());
		//}
		
		/*
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
		*/
	}
}
