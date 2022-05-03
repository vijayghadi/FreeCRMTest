package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	//Page Factory : OR
	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement createNew;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//div/input[@class='search']")
	WebElement company;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement save;
	
 
	//Initialize Page factory
	public ContactsPage() {
		PageFactory pf= new PageFactory();
		pf.initElements(driver, this);
	}
	
	//Actions
	public void createContacts(String firstname, String lastname) throws InterruptedException {
		createNew.click();
		
		while(!firstName.isDisplayed()) {
			System.out.println("Entered while");
			driver.navigate().refresh();
		}
		
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		//company.sendKeys(comp);
		save.click();
		
		Thread.sleep(1000);
	}
}