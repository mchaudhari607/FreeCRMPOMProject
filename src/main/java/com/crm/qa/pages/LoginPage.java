package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;

	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpbtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}

	//will declared the action which will perform on the page
	
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
		
	}
	
	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
	}
  
    public HomePage Login(String un,String pwd) {
    	username.sendKeys(un);
    	password.sendKeys(pwd);
    	loginbtn.click();
    	
    	return new HomePage();
    }
}
