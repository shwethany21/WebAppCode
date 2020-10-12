package com.mystoreapp.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.mystoreapp.base.BasePage;
import com.mystoreapp.pages.LandingPage;
import com.mystoreapp.pages.MyAccountPage;
import com.mystoreapp.pages.ProductPage;
import com.mystoreapp.pages.SignInPage;


public class BaseTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LandingPage landingPage ;
	SignInPage signInPage;
	MyAccountPage myAccountPage;
	ProductPage productPage;
	
	
	@BeforeTest
	public void setUp() throws IOException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver =  basePage.init_driver(prop);
		landingPage = new LandingPage(driver);
		signInPage = new SignInPage(driver);
		myAccountPage = new MyAccountPage(driver);
		productPage = new ProductPage(driver);		
		
	}
	
	
	@AfterTest()
	public void tearDown() {
		driver.quit();
	}

}
