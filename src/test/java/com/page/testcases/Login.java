package com.page.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.page.pages.HomePage;
import com.page.pages.LoginPage;
import com.page.pages.ZooAppPage;
import com.page.utilities.Utilities;


public class Login extends BaseTest  {
			
	
	@Test(dataProviderClass=Utilities.class,dataProvider="getdata")
	public void dologin(Hashtable<String ,String> data)
	{
	  HomePage home=new HomePage();
		
			LoginPage login= home.gotologin();
				
		login.doLogin(data.get("username") ,data.get("password"));

}
}