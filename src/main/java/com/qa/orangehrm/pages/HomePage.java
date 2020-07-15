package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.base.BasePage;

public class HomePage extends BasePage {
	WebDriver driver;
	
	//1. By class locators -- ObjectRepository(OR)
	
		//By homepageBanner = By.xpath("//div[@id='branding']/a/img");
		By dashboard = By.xpath("//h1[text()='Dashboard']");
		By loggedUserName = By.xpath("//a[@id='welcome']");
		
	
		
		// 2.create constructor of LoginPage
		public HomePage(WebDriver driver) {
			this.driver = driver;
			
		}
		
		// 3. page actions :Methods
		
		public String getHomePageTitle() {
			return driver.getTitle();
		}
		
		public String getHomepageDashboard() {
			if(driver.findElement(dashboard).isDisplayed()) {
				return driver.findElement(dashboard).getText();
			}
			return null;
		}
		
		public String getLoggedUserName() {
			if(driver.findElement(loggedUserName).isDisplayed()) {
				return driver.findElement(loggedUserName).getText();
			}
			return null;
			
		}
		
	
}
