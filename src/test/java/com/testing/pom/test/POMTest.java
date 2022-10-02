package com.testing.pom.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testing.pom.pages.DashboardPage;
import com.testing.pom.pages.LoginPage;
import com.testing.pom.pages.RegisterPage;

public class POMTest extends BaseIntegration {

	@Test(dataProvider = "loginData")
	public void doLogin(String testName, String uName, String uPass) {
		LoginPage login = new LoginPage(driver);
		if(testName.equals("Both are valid")) {
		DashboardPage dash = login.login(uName, uPass);
		
		Assert.assertTrue(dash.verifyDashboardTitle());
	    dash.clickOnLogout();
	}else {
		login.doInvalidLogin(uName, uPass);
		Assert.assertTrue(login.verifyLoginTitle());
	}
	}
		
		@Test(dataProvider = "registerData")
		public void doRegister(String testName, String uName, String uMobile, String uEmail, String uPass){
			LoginPage login = new LoginPage(driver);
			if(login.verifyLoginTitle()) {
				login.goToRegister();
			}
			RegisterPage register = new RegisterPage(driver);
			register.doRegister(uName, uMobile, uEmail, uPass);
			if(testName.equals("All are correct")) {
				Assert.assertTrue(register.verifyAlert());
			}
		}

}