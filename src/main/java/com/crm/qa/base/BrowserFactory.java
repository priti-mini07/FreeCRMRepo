
	
	package com.crm.qa.base;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.remote.DesiredCapabilities;

	public class BrowserFactory {
		public static BrowserFactory instance=null;
		ThreadLocal<WebDriver> webDriver =new ThreadLocal<WebDriver>();
		
		private BrowserFactory() {
		
		}
		 public static BrowserFactory getInstance() {
			 if(instance==null) {
				 instance= new BrowserFactory();
			 }
			 return instance;
		 }
		 
		 public final void setDriver(String browser)  {
			
			 
			 switch(browser){
				 case "chrome" :
					 
					 System.setProperty("webdriver.chrome.driver", "/Users/krishna/Downloads/chromedriver");
					 webDriver.set(new ChromeDriver());
			 }
		 }
			 
			 public WebDriver getDriver() {
				 //System.out.println("Got the local driver"+webDriver.toString());
				 return webDriver.get();
				 
			 }
			 
			 public void removeDriver() // Quits the driver and closes the browser
			   {
				 //System.out.println("Removing the local driver"+webDriver.toString());
			      webDriver.get().quit();
			      webDriver.remove();
			   }
			 
			 
		 }



