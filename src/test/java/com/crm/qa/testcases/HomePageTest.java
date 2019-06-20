package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		//Thread.sleep(10000);
		initialization();
		loginPage= new LoginPage();
		homePage=loginPage.enterInput(prop.getProperty("username"),prop.getProperty("password"));
		//contactsPage= new ContactsPage();
		
	}
	
	@Test(priority=0,enabled=true)
	public void verifyHomePage() {
		Assert.assertEquals(homePage.verifyHomePage(),true);
	}
	
	@Test(enabled=false)
	public void verifyContactPage() {
		Assert.assertEquals(false,true);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
