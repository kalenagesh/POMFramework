package com.testing.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "password")
	WebElement pass;
	
	@FindBy(id = "submit")
	WebElement submit;
	
	@FindBy(linkText = "Register a new membership")
	WebElement registerPageLink;
	
	public void enterEmail(String uName) {
		email.clear();
		email.sendKeys(uName);
	}
	
	public void enterPass(String uPass) {
		pass.clear();
		pass.sendKeys(uPass);
	}
	
	public DashboardPage clickOnLogin() {
		submit.click();
		return new DashboardPage(driver);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}


	public boolean verifyLoginTitle() {
		
		return getTitle().equals("Queue Codes | Log in");
	}
	

	public void goToRegister() {
		registerPageLink.click();	
	}
	
	public DashboardPage login(String uName, String uPass) {
		enterEmail(uName);
		enterPass(uPass);
		return clickOnLogin();		
	}
	
	public void doInvalidLogin(String uName, String uPass) {
		enterEmail(uName);
		enterPass(uPass);
		submit.click();
	}


}
