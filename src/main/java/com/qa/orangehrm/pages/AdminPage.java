package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.utils.Constants;
import com.qa.orangehrm.utils.ElementUtil;

public class AdminPage extends BasePage {
	
	private WebDriver driver;
	
	//1. By class locators -- ObjectRepository(OR)
	
	 By addButton = By.xpath("//input[@value='Add']");
	 By deleteButton = By.xpath("//input[@id='btnDelete']");
	 
	 //Add user - By locators
	 
	 By employeeName = By.xpath("//label[text()='Employee Name']//following::input[1]");
	 By username = By.xpath("//label[text()='Username']//following::input[1]");
	 By passWord = By.xpath("//label[text()='Password']//following::input[1]");
	 By cnfPassword = By.xpath("//label[text()='Confirm Password']//following::input[1]");
	 By saveButton = By.xpath("//input[@value='Save']");
	 By success = By.xpath("//div[contains(text(),'Successfully')]");
	 
		
		// 2.create constructor of LoginPage
		public AdminPage(WebDriver driver) {
			this.driver = driver;
			elementutil = new ElementUtil(this.driver);
			
			
		}
		
		// 3. page actions :Methods
		
		public String getAdminPageTitle() {
			 return elementutil.waitForTitleToBePresent(Constants.ADMIN_PAGE_TITLE, 10);
			
		}
		
		public void createNewUser(String empName,String userName,String pwd,String cnfpwd) {
				elementutil.waitForElementPresent(addButton, 5);
				elementutil.doClick(addButton);
				
				elementutil.waitForElementPresent(employeeName, 5);
				elementutil.doSendKeys(employeeName, empName);
			 
				elementutil.doSendKeys(username, userName);
				elementutil.doSendKeys(passWord, pwd);
				elementutil.doSendKeys(cnfPassword, cnfpwd);
			 
				elementutil.doClick(saveButton);
				
				//elementutil.waitForElementToBeClickable(saveButton, 5);
				elementutil.waitForElementToBeVisible(success, 10);
				
				
		}
	
	

}
