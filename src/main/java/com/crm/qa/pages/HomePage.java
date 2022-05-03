package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory : OR
	@FindBy(xpath="//span[contains(text(),'Vijay Ghadi')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Home')]")
	WebElement homeLink;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initializing the Page Object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(homeLink).build().perform();
		
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		Actions action = new Actions(driver);
		action.moveToElement(homeLink).build().perform();
		
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		Actions action = new Actions(driver);
		action.moveToElement(homeLink).build().perform();
		
		tasksLink.click();
		return new TasksPage();
	}

}
