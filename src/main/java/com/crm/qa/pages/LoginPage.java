package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BrowserFactory;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase {
	//WebDriver driver;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement userName;

	@FindBy(xpath="//input[@name='password']")
	WebElement pswd;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement logIn;
	
	@FindBy(xpath="//*[@id='ui']/div/div[2]/img")
	WebElement spinner;
	
	public LoginPage() {
		driver=BrowserFactory.getInstance().getDriver();
		PageFactory.initElements(this.driver, this);
		System.out.println("Driver in LoginPage : "+driver.toString());
		//this is current class object
	}
	
	public void invisiblityOfSpinner() {
		TestUtil.waitForInvisibilityOfSpinner(BrowserFactory.getInstance().getDriver(), spinner, 20000);

	}
	public String validateLoginPageTitle() {
		return BrowserFactory.getInstance().getDriver().getTitle();
	}
	
	public HomePage enterInput(String email, String pwd) {
		userName.sendKeys(email);
		pswd.sendKeys(pwd);
		logIn.click();
		return new HomePage();
	}
}
