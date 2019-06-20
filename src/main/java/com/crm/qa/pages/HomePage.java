package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
  @FindBy(xpath="//span[text()='Home']")
  WebElement homePageLink;
  
  @FindBy(xpath="//span[text()='Contacts']")
  WebElement contactsPageLink;
  
  @FindBy(xpath="//div[text()='Deals Summary']")
  WebElement dealSummaryText;
  
  @FindBy(xpath="//span[text()='Home']")
  WebElement ePageLink;
  
  @FindBy(xpath="//span[text()='Home']")
  WebElement PageLink;
  
  public HomePage() {
		PageFactory.initElements(driver, this);
		//this is current class object
	}
  
  public boolean verifyHomePage() {
	  return dealSummaryText.isDisplayed();
  }
  
  public ContactsPage navigateToContactsPage() {
	  contactsPageLink.click();
	  return new ContactsPage();
  }
  
  
}
