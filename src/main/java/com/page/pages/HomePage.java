package com.page.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.page.Base.Pager;

public class HomePage extends Pager  {
	
	//WebDriver driver;
			
	
	//public HomePage(WebDriver driver)
	//{
		
	//	this.driver=driver;
	//}
	
	public void gotoCustomers()
	{
		
		driver.findElement(By.cssSelector(".zh-customers")).click();
		
	}
	
	public void gotosupport()
	{
		
		driver.findElement(By.cssSelector(".zh-support")).click();
		
	}
	
	public void gotocontactSales()
	{
	
		//click("bmlBtn_css");
		//driver.findElement(By.cssSelector(".zh-contact")).click();
		
		//return new Contact();
	}
	
	
	public LoginPage gotologin()
	{
		click("Login_css");
		
		//driver.findElement(By.cssSelector(".zh-login")).click();
		
		return new LoginPage();
	}
	
	public void gotosignup()
	{
      driver.findElement(By.cssSelector(".zh-signup")).click();
		
	}
	
	public void validateFootlinks()
	{
		
		//driver.findElement(By.cssSelector(".zh-signup")).click();
	}
	
	public void gotoLearnmore()
	{
		
		driver.findElement(By.cssSelector("a.learn-more")).click();
	}

}
