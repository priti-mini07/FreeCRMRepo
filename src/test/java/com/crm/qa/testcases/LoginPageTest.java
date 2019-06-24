package com.crm.qa.testcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setup() throws InterruptedException {
		//Thread.sleep(500);
		  initialization();
		  System.out.println("Initialized");
		  loginPage= new LoginPage();
		  //loginPage.invisiblityOfSpinner();
	}
	
	@Test(priority=0,enabled=true)
	public void loginPageTileTest(){
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"CRM");
		System.out.println("loginPageTileTest executed");
		
	}
	
	@Test(priority=1)
	public void loginTest(){
		
		homePage=loginPage.enterInput(prop.getProperty("username"),prop.getProperty("password"));
		System.out.println("loginTest executed");
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void QuitDriver() {
		tearDown();
		System.out.println("Login Closed");
	}
	
	

}
