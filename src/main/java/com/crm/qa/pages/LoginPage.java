package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory  - OR:
	@FindBy(name="email")
	@CacheLookup
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement loginlink;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
		
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
		
	public HomePage login(String mail, String pwd){
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOf(loginlink));
//		
//		boolean res = loginlink.isDisplayed();
//		System.out.println(res);
		
//		Actions action = new Actions(driver);
//		action.moveToElement(loginlink).click(loginlink).perform();
		
//		loginlink.click();
//		
//		wait.until(ExpectedConditions.visibilityOf(email));
		
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click()", loginlink);
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOf(email));
		
		email.sendKeys(mail);
		password.sendKeys(pwd);
		loginBtn.click();	
			    	
		return new HomePage();
	}
}
