package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setup() {
		  initialization();
		  System.out.println("Initialized");
		  loginPage= new LoginPage();
	}
	
	@Test(priority=0,enabled=true)
	public void loginPageTileTest(){
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"CRM");
		System.out.println("Passed");
		
	}
	
	@Test(priority=1)
	public void loginTest(){
		
		homePage=loginPage.enterInput(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
		System.out.println("Login Closed");
	}
	
	

}
