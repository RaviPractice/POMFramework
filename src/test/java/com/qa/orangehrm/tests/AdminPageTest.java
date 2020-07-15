package com.qa.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;
import com.qa.orangehrm.pages.AdminPage;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.utils.Constants;

public class AdminPageTest extends BaseTest {
	HomePage homepage;
	AdminPage adminpage;
	
	@BeforeClass
	public void adminSetup() {
		homepage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		adminpage = homepage.doAdminTab();

	}
	
	@Test(priority=1)
	public void verifyAdminPageTitleTest() {
		String title = adminpage.getAdminPageTitle();
		System.out.println("Admin page title is :"+title);
		Assert.assertEquals(title,Constants.ADMIN_PAGE_TITLE);
		
	}
	
	@Test(priority=2)
	public void createUserTest() {
		adminpage.createNewUser("John Smith", "Mohit_1234", "abcd1234", "abcd1234");
		
	}
	
	

}
