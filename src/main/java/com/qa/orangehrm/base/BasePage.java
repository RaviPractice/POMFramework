package com.qa.orangehrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author RAVI
 *
 */

public class BasePage {
	WebDriver driver;
	Properties prop;
	
	/**
	 * this method is used to initilize the webdriver on the basis of driver
	 * @param broeserName
	 * @return
	 */
	
	public WebDriver init_driver(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		}
		else {
			System.out.println("please pass valid browser name :"+browserName);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		
		return driver;
		
	}
	/**
	 * this method is used to initilize the properties from config.properties file
	 * @return
	 */
	public Properties initilize_prop() {
		prop = new Properties();
		try {
			FileInputStream fip = new FileInputStream(".\\src\\main\\java\\com\\qa\\orangehrm\\config\\config.properties");
			prop.load(fip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}
	

}
