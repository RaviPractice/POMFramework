package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.base.BasePage;

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
		
	}
	
	// 3. page actions :Methods
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifForgotpasswordLink() {
		return driver.findElement(forgotpswdLink).isDisplayed();
	}
	
	public HomePage doLogin(String userName,String pswd) {
		driver.findElement(this.username).sendKeys(userName);
		driver.findElement(this.password).sendKeys(pswd);
		driver.findElement(this.loginButton).click();
		
		return new HomePage(driver);
		
		
	}
	

}
