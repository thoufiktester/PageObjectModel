package com.page.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import com.page.Base.Pager;



public class LoginPage extends Pager{
	
   	
	public ZooAppPage doLogin(String username,String password){
			
	     	type("email_css",username);
			click("nextbtn1_xpath");
			type("passwd_css",password);
			click("nextbtn2_xpath");
			
			//	driver.findElement(By.cssSelector("#login_id")).sendKeys(username);
			//	driver.findElement(By.xpath("//form[@id='login']//button[@id='nextbtn']")).click();
			//	driver.findElement(By.cssSelector("#password")).sendKeys(password);
				//driver.findElement(By.xpath("//form[@id='login']//button[@id='nextbtn']")).click();	
				
		return new ZooAppPage();
		
		}
		
		
		public void gotoSalesandMarketing(){
			
			
		}
		
		public void gotoFinance(){
			
			
		}
		
	

	}


