package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.utils.Constants;
import com.qa.orangehrm.utils.ElementUtil;

public class HomePage extends BasePage {
	WebDriver driver;
	
	//1. By class locators -- ObjectRepository(OR)
	
		//By homepageBanner = By.xpath("//div[@id='branding']/a/img");
		By dashboard = By.xpath("//h1[text()='Dashboard']");
		By loggedUserName = By.xpath("//a[@id='welcome']");
		By adminTab = By.xpath("//b[text()='Admin']");
		
		
	
		
		// 2.create constructor of LoginPage
		public HomePage(WebDriver driver) {
			this.driver = driver;
			elementutil = new ElementUtil(this.driver);
			
		}
		
		// 3. page actions :Methods
		
		public String getHomePageTitle() {
			return elementutil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10);
			
		}
		
		public String getHomepageDashboard() {
			elementutil.waitForElementToBeVisible(dashboard, 5);
			return elementutil.doGetText(dashboard);
		}
		
		public String getLoggedUserName() {
			elementutil.waitForElementToBeVisible(loggedUserName, 5);
			return elementutil.doGetText(loggedUserName);
			
		}
		
		public AdminPage doAdminTab() {
			elementutil.waitForElementPresent(adminTab, 5);
			elementutil.doClick(adminTab);
			
			return new AdminPage(driver);
			
		}
		
	
}
