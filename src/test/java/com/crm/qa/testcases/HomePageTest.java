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
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() throws InterruptedException{
		//Thread.sleep(1000);
		initialization();
		loginPage= new LoginPage();
		//loginPage.invisiblityOfSpinner();
		homePage=loginPage.enterInput(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=0,enabled=true)
	public void verifyHomePage() {
		Assert.assertEquals(homePage.verifyHomePage(),false);
	}
	
	@Test(enabled=false)
	public void verifyContactPage() {
		Assert.assertEquals(false,true);
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDownDriver() {
		tearDown();
		System.out.println("HomePage Closed");
	}

}
