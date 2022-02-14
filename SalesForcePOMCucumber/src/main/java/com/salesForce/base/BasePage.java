package com.salesForce.base;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	protected static WebDriver driver;
	//protected static GenerateReports report=GenerateReports.getInstance();
	//protected static WebDriverManager wm;
	
	public BasePage(WebDriver driver1) {
		driver=driver1;
		PageFactory.initElements(driver1, this);
	}
	
	public static void closeDriver()
	{
		driver.close();
	}
	
	public static void closeAllDriver()
	{
		driver.quit();
	}
	
	public static void launchApp(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	public static void enterText(WebElement element,String text)
	{
		element.sendKeys(text);
	//	report.logTestInfo("Text Entered");
	}
	public static void clickElement(WebElement element)
	{
		//report.logTestInfo("Element Clicked");
		element.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void clearElement(WebElement element)
	{
		element.clear();
	}
	public static void waitUntilVisible(WebElement element)
	{
		WebDriverWait waits=new WebDriverWait(driver,30);
		waits.until(ExpectedConditions.visibilityOf(element));
	//	report.logTestInfo("Waiting for element to be visible");
	}
	
	public static void waitUntilElementClickable(WebElement element)
	{
		WebDriverWait waits=new WebDriverWait(driver,40);
		waits.until(ExpectedConditions.elementToBeClickable(element));
		//report.logTestInfo("Waiting for element to be clickable");
	}
	
	public static void waitUntilAlertPresent()
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void alertAccept()
	{
		waitUntilAlertPresent();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
	}
	
	public static void mouseOver(WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	
	
	public static String getTitleOfPage()
	{
		return driver.getTitle();
	}
	public static String getUrlOfPage()
	{
		return driver.getCurrentUrl();
	}
	
	
	public static void selectByText(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
		//report.logTestInfo("Select choose the data from dropdown");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void pageRefresh()
	{
		driver.navigate().refresh();
	}

}


