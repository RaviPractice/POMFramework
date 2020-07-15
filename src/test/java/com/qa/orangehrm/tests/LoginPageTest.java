package com.qa.orangehrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.utils.Constants;

public class LoginPageTest {
	WebDriver driver;
	Properties prop;
	
	BasePage basepage;
	LoginPage loginpage;
	
	@BeforeTest
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.initilize_prop();
		driver = basepage.init_driver(prop);
		loginpage = new LoginPage(driver);	
	}
	
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
	
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
