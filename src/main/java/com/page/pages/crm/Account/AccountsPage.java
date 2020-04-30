package com.page.pages.crm.Account;

import org.openqa.selenium.By;

import com.page.Base.Pager;

public class AccountsPage extends Pager { 
	
	public CreateAccountPage gotoCreateAccount()
	{

		click("createAccount_css");
	//driver.findElement(By.cssSelector("#topRightIcons > span.customPluswithImpotBtnCon.pR > link-to > button")).click();
	
	return new  CreateAccountPage();
	
	}
	

	public void gotoImportAccount()
	{
		
		
		
	}


}
