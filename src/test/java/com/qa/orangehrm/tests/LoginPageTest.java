package com.qa.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;
import com.qa.orangehrm.listeners.ExtentReportListener;
import com.qa.orangehrm.listeners.TestAllureListener;
import com.qa.orangehrm.listeners.TesultsListener;
import com.qa.orangehrm.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Listeners(ExtentReportListener.class)
//@Listeners(TestAllureListener.class)
@Listeners(TesultsListener.class)
@Epic("Epic - 101 : design loginpage with different features")
@Story("US - 102 : design basic login page with signup,title,login..")
public class LoginPageTest extends BaseTest {
	
	
	@Test(priority=2)
	@Description("Verifying Login page title test")
	@Severity(SeverityLevel.NORMAL)
	public void verifyLoginPageTitleTest() {
		String title = loginpage.getLoginPageTitle();
		System.out.println("login page title is :"+title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE,"Login page title is not matched..");
		
	}
	
	@Test(priority=1)
	@Description("Verify ForgotpasswordLink")
	@Severity(SeverityLevel.MINOR)
	public void verifyForgotpswdLinkTest() {
		Assert.assertTrue(loginpage.verifForgotpasswordLink(),"forgot passwordlink is not displayed..");
	}
	

	@Test(priority=3)
	@Description("checking user login.")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {
		loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}

	
	
}
