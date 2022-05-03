package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(enabled=false)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM","Home Page Title not matched");
	}
	
	@Test(enabled=false)
	public void verifyUserNameTest(){
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test
	public void clickOnContactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
