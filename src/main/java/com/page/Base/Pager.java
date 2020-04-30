package com.page.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.page.utilities.ExcelReader;
import com.page.utilities.ExtentManager;
import com.page.utilities.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Pager {
	
	
	public static WebDriver driver;

       public static TopMenu menu;
       
       public static Properties Config=new Properties();
   	public static Properties OR=new Properties();
   	public static FileInputStream fis;
   	public static Logger log=Logger.getLogger("devpinoyLogger");
   	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\page\\excel\\testdata.xlsx");
   	public static WebDriverWait wait;
   	public ExtentReports reo=ExtentManager.getInstance();
   	public static ExtentTest test;
   	
   	public static String browser;
	
	public Pager()
	{
	  

		if(driver==null)
		{
			
				try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\page\\properties\\Config.properties");
			
			} 
			
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				Config.load(fis);
				log.debug("Config file loaded!!!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\page\\properties\\OR.Properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				OR.load(fis);
				log.debug("OR file loaded!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()){
					
					browser = System.getenv("browser");
				
				}else{
					
					browser = Config.getProperty("browser");
					
				}
				
				Config.setProperty("browser", browser);
			 

				 
			    if(Config.getProperty("browser").equals("chrome"))
			 
			 {
				 
			
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\com\\page\\executables\\chromedriver.exe");
		
        Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
                     
        driver=new ChromeDriver(options);
        log.debug("Chrome Launched");
        
			 }
			    
			    else if (Config.getProperty("browser").equals("ie")) {
					
					 
					 System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\com\\page\\executables\\IEDriverServer.exe");
					 driver=new InternetExplorerDriver();
					 
				 }
				    
				 else if (Config.getProperty("browser").equals("firefox")) {

						 System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\com\\page\\executables\\geckodriver.exe");
						driver = new FirefoxDriver();
				 }  
		
			    driver.get(Config.getProperty("testsiteurl"));
				log.debug("Navigated to : " + Config.getProperty("testsiteurl"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
						TimeUnit.SECONDS);
				wait = new WebDriverWait(driver, 5);
		menu=new TopMenu(driver);
	}
	
	}
	

	public static void quit()
	{
		driver.quit();
	}
	
	//Common Keywords
	public static void click(String Locator)
	{
		
		if(Locator.endsWith("_css"))
		{
			
			driver.findElement(By.cssSelector(OR.getProperty(Locator))).click();
					
		}
		else if(Locator.endsWith("_xpath"))
		{
			driver.findElement(By.xpath(OR.getProperty(Locator))).click();
		}
		else if(Locator.endsWith("_id"))
		{
			driver.findElement(By.id(OR.getProperty(Locator))).click();
		}
		
		log.debug("Clicking The Element:"+Locator);
		
		test.log(LogStatus.INFO, "clicking in"+Locator);
	}
	
	
	public static void type(String Locator, String Value)
	{
		
		if(Locator.endsWith("_css"))
		{
			
			driver.findElement(By.cssSelector(OR.getProperty(Locator))).sendKeys(Value);
					
		}
		else if(Locator.endsWith("_xpath"))
		{
			driver.findElement(By.xpath(OR.getProperty(Locator))).sendKeys(Value);
		}
		else if(Locator.endsWith("_id"))
		{
			driver.findElement(By.id(OR.getProperty(Locator))).sendKeys(Value);
		}
		
		log.debug("Typing in Element:"+Locator+ "Entered value as :" + Value);
		
		test.log(LogStatus.INFO, "Typing in"+Locator+ "Entered value as :" +Value);
	}
		
	

		public boolean isElementPresent(By by) {

			try {

				driver.findElement(by);
				return true;

			} catch (NoSuchElementException e) {

				return false;

			}

		}
		
		
		
		
		public static void verifyEquals(String expected, String actual) throws IOException {

			try {

				Assert.assertEquals(actual, expected);

			} catch (Throwable t) {

				Utilities.Capturescreenshot();
				// ReportNG
				Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + Utilities.ScreenshotName + "><img src=" + Utilities.ScreenshotName
						+ " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");
				// Extent Reports
				test.log(LogStatus.FAIL, " Verification failed with exception : " + t.getMessage());
				test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.ScreenshotName));

			}

		}
}



