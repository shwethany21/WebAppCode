package com.mystoreapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mystoreapp.base.BasePage;
import com.mystoreapp.util.AppConstants;
import com.mystoreapp.util.ElementActions;

public class ProductPage extends BasePage{

	WebDriver driver;
	BasePage basePage;
	ElementActions elementActions;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	By productname = By.xpath("//a[@class='product-name' and @title='Faded Short Sleeve T-shirts']");
	By addtocartBtn = By.id("add_to_cart");
	By proceedtocheckout = By.xpath("//a[@class='btn btn-default button button-medium' and @title='Proceed to checkout']");

	By successmessage = By.xpath("");
	By productnameincart = By.xpath("//span[@id='layer_cart_product_title']");
	By productsize = By.xpath("//span[@id='layer_cart_product_attributes']");
	By productquantity = By.xpath("//span[@id='layer_cart_product_quantity']");
	By productprice = By.xpath("//span[@id='layer_cart_product_price']");


	public String doGetProductPageTitle() {
		return elementActions.doGetPageTitle(AppConstants.PRODUCT_PAGE_TITLE);
	}

	public void clickOnProduct() {
		elementActions.waitForElementIsVisbile(productname);
		elementActions.getElement(productname).click();

	}

	public void clickOnAddToCartButton() {
		elementActions.waitForElementIsVisbile(addtocartBtn);
		elementActions.getElement(addtocartBtn).click();
	}

	public void clickProceedToCheckOutButton() {
		elementActions.waitForElementIsVisbile(proceedtocheckout);
		elementActions.getElement(proceedtocheckout).click();
	}


	public String getSuccessMessageText() {
		elementActions.waitForElementIsVisbile(successmessage);
		return elementActions.doGetText(successmessage);
	}
	
	public String getProductNameText() {
		elementActions.waitForElementIsVisbile(productnameincart);
		return elementActions.doGetText(productnameincart);
	}
	public String getProductSizeText() {
		elementActions.waitForElementIsVisbile(productsize);
		return elementActions.doGetText(productsize);
	}
	public String getProductQuantityText() {
		elementActions.waitForElementIsVisbile(productquantity);
		return elementActions.doGetText(productquantity);
	}
	public String getProductPriceText() {
		elementActions.waitForElementIsVisbile(productprice);
		return elementActions.doGetText(productprice);
	}
	

}
