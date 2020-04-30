package com.page.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.page.pages.crm.Account.AccountsPage;

public class TopMenu {
	
	
	WebDriver driver;
	
	public TopMenu(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void gotoHome()
	{
		
		
	}
	

	public void gotoLeads()
	{
		
		
	}
	
	

	public void gotoContacts()
	{
		
		
	}

	

	public AccountsPage gotoAccounts()
	{
		
		Pager.click("Accounttab_xpath");
		
		//driver.findElement(By.xpath("//*[@id='mainMenuTabDiv']/crm-menu/div[1]/crm-tab/div[2]/div[4]/a")).click();
	
	return new AccountsPage();
	
	}
	

	public void gotoSignout()
	{
		
		
	}
}
