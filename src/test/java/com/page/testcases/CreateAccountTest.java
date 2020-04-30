package com.page.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.page.Base.Pager;
import com.page.pages.ZooAppPage;
import com.page.pages.crm.Account.AccountsPage;
import com.page.pages.crm.Account.CreateAccountPage;
import com.page.utilities.Utilities;

public class CreateAccountTest {
	
	@Test(dataProviderClass=Utilities.class,dataProvider="getdata")
	
	public void createAccountTest(Hashtable<String ,String>data)
	{
		
		ZooAppPage zoo=new ZooAppPage();
		
		zoo.gotocrm();
		
				AccountsPage account=Pager.menu.gotoAccounts();
								
				CreateAccountPage cp=account.gotoCreateAccount();
				
				cp.CreateAccount(data.get("AccountName"));
		
	}
	
	

}
