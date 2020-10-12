package com.mystoreapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mystoreapp.base.BasePage;
import com.mystoreapp.util.AppConstants;
import com.mystoreapp.util.ElementActions;

public class MyAccountPage extends BasePage{
	
	WebDriver driver;
	BasePage basePage;
	ElementActions elementActions;
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	By tShirtLink = By.xpath("(//a[@title='T-shirts'])[2]");
	
	public String doGetMyAccountPageTitle() {
		return elementActions.doGetPageTitle(AppConstants.MY_ACCOUNT_PAGE_TITLE);
	}
	
	public ProductPage doClickOnTShirtLink() {
		elementActions.doClick(tShirtLink);
		return new ProductPage(driver);
	}
	
}
