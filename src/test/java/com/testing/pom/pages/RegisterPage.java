package com.testing.pom.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "name")
	WebElement rName;
	
	@FindBy(id = "mobile")
	WebElement rMobile;
	
	@FindBy(id = "email")
	WebElement rEmail;
	
	@FindBy(id = "password")
	WebElement rPass;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement rSubmit;
	
	public void enterName(String uName) {
		rName.clear();
		rName.sendKeys(uName);
	}
	
	public void enterMobile(String uMobile) {
		rMobile.clear();
		rMobile.sendKeys(uMobile);
	}
	
	public void enterEmail(String uEmail) {
		rEmail.clear();
		rEmail.sendKeys(uEmail);
	}
	
	public void enterPass(String uPass) {
		rPass.clear();
		rPass.sendKeys(uPass);
	}
	
	public void clickOnSubmit() {
		rSubmit.click();
	}
	
	public String handleAlert() {
		Alert alt = driver.switchTo().alert();
		String msg = alt.getText();
		alt.accept();
		return msg;
	}
	
	public boolean verifyAlert() {
		return handleAlert().equals("User registered successfully.");
	}
	
	public void doRegister(String uName, String uMobile, String uEmail, String uPass) {
		enterName(uName);
		enterMobile(uMobile);
		enterEmail(uEmail);
		enterPass(uPass);
		clickOnSubmit();
	}
}
