package com.qa.orangehrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.utils.Constants;

public class HomePageTest {
	
	WebDriver driver;
	Properties prop;
	
	BasePage basepage;
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeTest
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.initilize_prop();
		driver = basepage.init_driver(prop);
		loginpage = new LoginPage(driver);
		homepage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=2,description="Verifying homepage title")
	public void verifHomePageTitleTest() {
		String title = homepage.getHomePageTitle();
		System.out.println("homepage title is :"+title);
		Assert.assertEquals(title,Constants.HOME_PAGE_TITLE,"Home page title is not matched..");
		
	}
	@Test(priority=1,description = "verifying Homepage dashboard")
	public void HomepageDashboardTest() {
		String dashboard = homepage.getHomepageDashboard();
		System.out.println("homepage header is :"+dashboard);
		Assert.assertEquals(dashboard,Constants.HOME_PAGE_HEADER,"Home page banner is not matched..");
		
	}
	
	@Test(priority=3,description="Verifying Logged User")
	public void loggedInUserTest() {
		String user = homepage.getLoggedUserName();
		System.out.println("homepage header is :"+user);
		Assert.assertEquals(user,Constants.LOGGED_USER,"Logged user is not matched..");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	

}
