package com.page.testcases;

import org.testng.annotations.AfterSuite;

import com.page.Base.Pager;



public class BaseTest {
	
	
	@AfterSuite
	public void teardown()
	{
		
	Pager.quit();
	}

}
