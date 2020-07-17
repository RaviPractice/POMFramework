package com.qa.orangehrm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import com.qa.orangehrm.utils.ElementUtil;
import com.qa.orangehrm.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author RAVI
 *
 */

public class BasePage {
	public WebDriver driver;
	public Properties prop;
	public ElementUtil elementutil;
	public OptionsManager optionsmanager;
	
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	
	public static  synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	
	/**
	 * this method is used to initilize the webdriver on the basis of driver
	 * @param broeserName
	 * @return
	 */
	
	public WebDriver init_driver(Properties prop) {
		optionsmanager = new OptionsManager(prop);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver","D:\\MukeshAutomation\\drivers\\chrome\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(optionsmanager.getChromeOptions()));
			
			//driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(optionsmanager.getFirefoxOptions()));
			//System.setProperty("webdriver.gecko.driver", "D:\\MukeshAutomation\\drivers\\geckodriver.exe");
			//driver = new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			tlDriver.set(new InternetExplorerDriver());
			//System.setProperty("webdriver.ie.driver", "D:\\MukeshAutomation\\drivers\\IEDriverServer-32.exe");
			//driver = new InternetExplorerDriver();
			
		}
		else {
			System.out.println("please pass valid browser name :"+browserName);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		
		return getDriver();
		
	}
	/**
	 * this method is used to initilize the properties from config.properties file
	 * @return
	 */
	public Properties initilize_prop() {
		prop = new Properties();
		String path = null;
		String env = null;
		
		try {
			env = System.getProperty("env");
			System.out.println(" enviornment value  is ---->" + env);
			
			if(env == null) {
				path = ".\\src\\main\\java\\com\\qa\\orangehrm\\config\\config.properties";	
			}
			else {
				switch(env) {
				
				case "qa":
					path = ".\\src\\main\\java\\com\\qa\\orangehrm\\config\\qa.config.properties";	
				break;
				
				case "stg":
					path = ".\\src\\main\\java\\com\\qa\\orangehrm\\config\\stg.config.properties";	
					break;
					
				case "dev":
					path = ".\\src\\main\\java\\com\\qa\\orangehrm\\config\\dev.config.properties";	
					break;
				default:
					System.out.println(" please enter valid enev value -->" + env);
					break;
					
				}
			}
			FileInputStream fip = new FileInputStream(".\\src\\main\\java\\com\\qa\\orangehrm\\config\\config.properties");
			prop.load(fip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}
	/**
	 * this method is used to take the screenshot
	 */
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
			//FileHandler.copy(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	

}
