package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.utils.Constants;
import com.qa.orangehrm.utils.ElementUtil;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	
	//1. By class locators -- ObjectRepository(OR)
	
	By username = By.id("txtUsername");
	By password = By.id("txtPassword");
	By loginButton = By.id("btnLogin");
	By forgotpswdLink = By.linkText("Forgot your password?");
	
	// 2.create constructor of LoginPage
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
		
		
	}
	
	// 3. page actions :Methods
	
	public String getLoginPageTitle() {
		 return elementutil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 10);
		
	}
	
	public boolean verifForgotpasswordLink() {
		return	elementutil.doIsDisplayed(forgotpswdLink);
		
		
	}
	
	public HomePage doLogin(String userName,String pswd) {
		
		elementutil.waitForElementToBeVisible(username, 5);
		elementutil.doSendKeys(this.username, userName);
		elementutil.doSendKeys(this.password, pswd);
		elementutil.doClick(loginButton);

		return new HomePage(driver);
		
		
	}
	

}
