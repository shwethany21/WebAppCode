package com.mystoreapp.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystoreapp.util.AppConstants;
import com.mystoreapp.util.ElementActions;

public class AppFlow_Scenario1Test extends BaseTest{
	
	@Test
	public void verifyScenario1Test() {
		// Login to http://Automationpractice.com
		String landingPageTitle = landingPage.doGetLandlingPageTitle();
		System.out.println("Landing Page title is: " + landingPageTitle);
		assertEquals(landingPageTitle, AppConstants.LANDING_PAGE_TITLE);
	
		//Sign in using the credentials:username: jetblue@grr.la & password: jetblue
		landingPage.clickOnSignInLink();
		String signInPageTitle = signInPage.doGetSignInPageTitle();
		System.out.println("SignIn Page title is: " + signInPageTitle);
		assertEquals(signInPageTitle, AppConstants.SIGNIN_PAGE_TITLE);
		signInPage.doSignIn(prop.getProperty("username"), prop.getProperty("password"));
		
		// Select the category as T-Shirts
		String myAccountPageTitle = myAccountPage.doGetMyAccountPageTitle();
		System.out.println("MyAccount Page title is: " + myAccountPageTitle);
		assertEquals(myAccountPageTitle, AppConstants.MY_ACCOUNT_PAGE_TITLE);
		myAccountPage.doClickOnTShirtLink();
		
		//Click on the product: Faded Short Sleeve T-shirts
		
		String productPageTitle = productPage.doGetProductPageTitle();
		System.out.println("Product Page title is: " + productPageTitle);
		assertEquals(productPageTitle, AppConstants.PRODUCT_PAGE_TITLE);
		productPage.doGetProductPageTitle();
		productPage.clickOnProduct();
//		Thread.sleep(50000);
		
		
		// 5. Click on Add to Cart
		 
		productPage.clickOnAddToCartButton();
//		String successMessageInCart = productPage.getSuccessMessageText();
//		System.out.println("Success Message is: " + successMessageInCart);
//		assertEquals(successMessageInCart, AppConstants.ADD_TO_CART_SUCCESS_MESSAGE);
		
		String productNameInCart = productPage.getProductNameText();
		System.out.println("Product Name is: " + productNameInCart);
		assertEquals(productNameInCart, AppConstants.PRODUCT_NAME);
		
		String productSizeInCart = productPage.getProductSizeText();
		System.out.println("Product Size is: " + productSizeInCart);
		assertEquals(productSizeInCart, AppConstants.PRODUCT_COLOR);
		
		String productQuantityInCart = productPage.getProductQuantityText();
		System.out.println("Product Quantity is: " + productQuantityInCart);
		assertEquals(productQuantityInCart, AppConstants.PRODUCT_QUENTITY);
		
		String productPriceInCart = productPage.getProductPriceText();
		System.out.println("Product Price is: " + productPriceInCart);
		assertEquals(productPriceInCart, AppConstants.PRODUCT_PRICE);
		
		//	Click on proceed to checkout
		productPage.clickProceedToCheckOutButton();
		
		
	}

}
