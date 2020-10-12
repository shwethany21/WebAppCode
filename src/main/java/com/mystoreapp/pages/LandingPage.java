package com.mystoreapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mystoreapp.base.BasePage;
import com.mystoreapp.util.AppConstants;
import com.mystoreapp.util.ElementActions;



public class LandingPage extends BasePage{
	WebDriver driver;
	BasePage basePage;
	ElementActions elementActions;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}
	
	// Create the By locator of the LandingPage
	By signInLink = By.xpath("//a[@title='Log in to your customer account']");
	
	
	//Page Actions
	
	public String doGetLandlingPageTitle() {
		return elementActions.doGetPageTitle(AppConstants.LANDING_PAGE_TITLE);
	}
	
	public SignInPage clickOnSignInLink() {
		elementActions.getElement(signInLink).click();
		return new SignInPage(driver);
	}


}
