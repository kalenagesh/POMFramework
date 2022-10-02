package com.testing.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "hlogout")
	WebElement logout;

	public String getTitle() {
		return driver.getTitle();
	}

	public boolean verifyDashboardTitle() {
	return getTitle().equals("Queue Codes | Dashboard");

	}

	public void clickOnLogout() {
		logout.click();
	}

}
