package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	String sheetName="Contacts";

	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		Thread.sleep(20000);
		initialization();
		loginPage= new LoginPage();
		homePage=loginPage.enterInput(prop.getProperty("username"),prop.getProperty("password"));
		contactsPage= homePage.navigateToContactsPage();
		
		
	}
	
	@Test(priority=0)
	public void verifyContactTest() {
		Assert.assertEquals(contactsPage.verifyContactPage(), true);
	}
	
	@Test(priority=1)
	public void verifyNewContactPageTest() {
		Assert.assertEquals(contactsPage.createNewContactLink(), true);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data= TestUtil.getDataFromExcel(sheetName);
		return data;
	}
	
	@Test(dataProvider="getData",priority=2)
	public void verifyNewContactTest(String fname, String lName, String company, String socialAcct, String description) {
		contactsPage.createNewContactLink();
		contactsPage.enterDetailsOfNewContact(fname, lName, company, socialAcct, description);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
