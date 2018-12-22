package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: Manish Chaudhari')]")
	WebElement userNameLable;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLinks;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyUserName() {
		return userNameLable.isDisplayed();
	}
	public ContactsPage clickOnContactLink() {
		
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLinks.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
		
    
	
	
	
}
}
