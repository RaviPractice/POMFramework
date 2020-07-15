package com.qa.orangehrm.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.orangehrm.pages.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public Properties prop;
	
	public BasePage basepage;
	public LoginPage loginpage;
	
	@BeforeTest
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.initilize_prop();
		driver = basepage.init_driver(prop);
		loginpage = new LoginPage(driver);	
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}


}
