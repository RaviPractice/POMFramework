package com.qa.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;
import com.qa.orangehrm.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	
	@Test(priority=2,description = "Verify Login Page Title")
	public void verifyLoginPageTitleTest() {
		String title = loginpage.getLoginPageTitle();
		System.out.println("login page title is :"+title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE,"Login page title is not matched..");
		
	}
	
	@Test(priority=1,description = "Verify ForgotpasswordLink")
	public void verifyForgotpswdLinkTest() {
		Assert.assertTrue(loginpage.verifForgotpasswordLink(),"forgot passwordlink is not displayed..");
	}
	
	@Test(priority=3)
	public void loginTest() {
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}

	
	
}
