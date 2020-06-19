package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class SampleTest 
{
	public WebDriver driver;
	@BeforeMethod
	public void m1() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Chittaranjan\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
		Thread.sleep(6000);
	}
	@Test
	public void test()
	{
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("hgcdvjscj");
		driver.findElement(By.xpath("//input[@type='email']//following::td//input[@type='password']")).sendKeys("hgcdvjsgcaxhcj");
		WebElement e=driver.findElement(By.xpath("//input[@type='email']//following::td//input[@type='submit']"));
		/*
		 * JavascriptExecutor js= (JavascriptExecutor)driver;
		 * js.executeScript("argument[0].click();",e);
		 */
		e.click();
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
		
		String x=driver.findElement(By.xpath("//div[@role='alert']")).getText();
		System.out.println(x);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	

}
