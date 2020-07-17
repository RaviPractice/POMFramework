package com.qa.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;
import com.qa.orangehrm.pages.AdminPage;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.utils.Constants;
import com.qa.orangehrm.utils.ExcelUtil;

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
	
	@DataProvider
	public Object[][] createUsersTest() {
		Object[][] data = ExcelUtil.getTestData(Constants.USERS_SHEET_NAME);
		return data;
		
	}

	
	@Test(priority=2,dataProvider = "createUsersTest",enabled = false)
	public void createUserTest(String empName,String userName,String pswd,String cnfpswd) {
		adminpage.createNewUser(empName,userName,pswd,cnfpswd);
		
	}
	
	

}
