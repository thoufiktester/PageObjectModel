package com.page.pages;

import org.openqa.selenium.By;


import com.page.Base.Pager;
import com.page.pages.crm.CRMHomePage;

public class ZooAppPage extends Pager {
	
	public  CRMHomePage gotocrm()
	{
		
		click("CrmLink_css");
		//driver.findElement(By.cssSelector("#zl-myapps > div.ea-app-container > div:nth-child(6) > div > a > span")).click();
		
		return new  CRMHomePage();
	}

	
	public void gotochat()
	{
		driver.findElement(By.cssSelector("#zl-myapps > div.ea-app-container > div:nth-child(4) > div > a > span")).click();
	
	}
	
	public void gotoconnect()
	{
		driver.findElement(By.cssSelector("#zl-myapps > div.ea-app-container > div:nth-child(5) > div > a > span")).click();
		
	}
}
