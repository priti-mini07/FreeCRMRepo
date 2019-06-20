package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//input[@name='email']")
	WebElement userName;

	@FindBy(xpath="//input[@name='password']")
	WebElement pswd;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement logIn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		//this is current class object
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage enterInput(String email, String pwd) {
		userName.sendKeys(email);
		pswd.sendKeys(pwd);
		logIn.click();
		return new HomePage();
	}
}
