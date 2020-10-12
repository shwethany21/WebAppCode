package com.mystoreapp.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;

	/**
	 * This method is for intializing the driver and launch the browser and then
	 * open the URL
	 * 
	 * @param prop
	 * @return this method will return the WebDriver - driver
	 */
	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser");
		Boolean isHeadless = Boolean.parseBoolean((prop.getProperty("headless")));
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (isHeadless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (isHeadless) {
				FirefoxOptions fo = new FirefoxOptions();
				fo.addArguments("--headless");
				driver = new FirefoxDriver(fo);
			} else {
				driver = new FirefoxDriver();
			}

		} else {
			System.out.println(browserName + " Browser name not found, please pass the correct browser name ");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;
	}

	/**
	 * This method is for intializing the properties from config.properties file
	 * 
	 * @return this method will return the Properties - prop
	 * @throws IOException 
	 * @throws Exception 
	 */
	public Properties init_properties() throws IOException  {
		prop = new Properties();
		String path = ".\\src\\main\\java\\com\\mystoreapp\\config\\prop.properties" ;
		FileInputStream ip = null;
		try {
			ip = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop.load(ip);
		return prop;
	}
}
