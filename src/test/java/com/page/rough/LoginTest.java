package com.page.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.page.Base.Pager;
import com.page.pages.HomePage;
import com.page.pages.LoginPage;
import com.page.pages.ZooAppPage;
import com.page.pages.crm.Account.AccountsPage;
import com.page.pages.crm.Account.CreateAccountPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends Pager {
	
	
	
	
	public static void main(String[] args) {
		
		
		
//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\com\\page\\executables\\chromedriver.exe");
		
	//	WebDriver driver=new ChromeDriver();
		
		//driver.get("https://www.zoho.com");
		
	//	driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
     //  HomePage home=new HomePage();
		
		//LoginPage login= home.gotologin();
			
		//ZooAppPage zoo=login.doLogin("t.ahamedmtp@gmail.com", "whiterhino@88");
		
		//zoo.gotocrm();
				
		AccountsPage account=Pager.menu.gotoAccounts();
						
		CreateAccountPage cp=account.gotoCreateAccount();
		
		cp.CreateAccount("Thoufik");
		
		
		
	}

}
