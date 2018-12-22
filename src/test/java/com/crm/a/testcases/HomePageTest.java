package com.crm.a.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;



public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testutil;
	public HomePageTest() {
		
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		testutil =new TestUtil();
		
		 loginPage = new LoginPage();
		 homePage=loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	//Test cases should be independent with each other.
	//Before each test case launch the browser once executed close it
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homepagetitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle,"CRMPRO","Home page titlenot matched");
		
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testutil.switchToFrame();
	//	boolean userName=homePage.verifyUserName();
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test(priority=3)
	public void verifyContactLink()
	{
		testutil.switchToFrame();
		contactsPage=homePage.clickOnContactLink();
		
	}
	
	
	@AfterMethod
    public void tearDown() {
    	driver.quit();
    }

}
