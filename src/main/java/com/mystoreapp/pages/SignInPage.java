package com.mystoreapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mystoreapp.base.BasePage;
import com.mystoreapp.util.ElementActions;

public class SignInPage extends BasePage{
	WebDriver driver;
	BasePage basePage;
	ElementActions elementActions;
	

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	By emailAddress = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='passwd']");
	By signInButton = By.xpath("//button[@id='SubmitLogin']");

	public String doGetSignInPageTitle() {
		return elementActions.doGetPageTitle(com.mystoreapp.util.AppConstants.SIGNIN_PAGE_TITLE);
	}

	public MyAccountPage doSignIn(String email, String pwd ) {
		elementActions.waitForElementPresent(emailAddress);
		System.out.println("Credentails are " + email + "and" + pwd);
		elementActions.doSendKeys(emailAddress, email);
		elementActions.doSendKeys(password, pwd);
		elementActions.doClick(signInButton);
		return new MyAccountPage(driver);
	}
}



