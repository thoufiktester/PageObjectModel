package com.page.pages.crm.Account;

import org.openqa.selenium.By;

import com.mysql.cj.jdbc.Driver;
import com.page.Base.Pager;

public class CreateAccountPage extends Pager {
	
	
	
	public void CreateAccount(String AccountName)
	
	{
	
		type("Create_css",AccountName);
		
		
	}

}
